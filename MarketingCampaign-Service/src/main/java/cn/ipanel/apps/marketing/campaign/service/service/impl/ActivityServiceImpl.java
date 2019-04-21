package cn.ipanel.apps.marketing.campaign.service.service.impl;

import cn.ipanel.apps.marketing.campaign.service.controller.resp.tv.ActivityTVVO;
import cn.ipanel.apps.marketing.campaign.service.dao.*;
import cn.ipanel.apps.marketing.campaign.service.dto.CustomerVO;
import cn.ipanel.apps.marketing.campaign.service.entity.*;
import cn.ipanel.apps.marketing.campaign.service.global.Globals;
import cn.ipanel.apps.marketing.campaign.service.global.MyCommonException;
import cn.ipanel.apps.marketing.campaign.service.global.RequestParamErrorException;
import cn.ipanel.apps.marketing.campaign.service.service.IActivityService;
import cn.ipanel.apps.marketing.campaign.service.service.bean.BossOrder;
import cn.ipanel.apps.marketing.campaign.service.service.bean.CheckType1Order;
import cn.ipanel.apps.marketing.campaign.service.service.feign.IBossService;
import cn.ipanel.apps.marketing.campaign.service.service.feign.bean.BuyOfferReq;
import cn.ipanel.apps.marketing.campaign.service.service.feign.bean.CheckGoodsOrderReq;
import cn.ipanel.apps.marketing.campaign.service.service.feign.bean.CheckIsMarketingReq;
import cn.ipanel.apps.marketing.campaign.service.service.feign.bean.CheckProductOrderReq;
import cn.ipanel.apps.marketing.campaign.service.task.AsyncTask;
import cn.ipanel.apps.marketing.campaign.service.util.DateUtil;
import cn.ipanel.apps.marketing.campaign.service.util.SnowflakeIdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/14 下午4:55
 * Modified By:
 * Description: 活动弹窗主要service
 */
@Slf4j
@Service
public class ActivityServiceImpl implements IActivityService {

    static final String RESPONSE_AGREE = "yes";
    static final String RESPONSE_DISAGREE = "no";
    private static final String RESPONSE_THINK = "think";
    private static final List<String> activityResponse = Arrays.asList(RESPONSE_AGREE, RESPONSE_DISAGREE, RESPONSE_THINK);

    private ActivityRepository activityRepository;
    private ActivityUserRecordRepository activityUserRecordRepository;
    private Type1ActivityRepository type1Repository;
    private Type2ActivityRepository type2Repository;
    private SnowflakeIdWorker snowflakeIdWorker;
    private AsyncTask asyncTask;
    private IBossService bossService;
    private ProductRepository productRepository;
    private GoodsRepository goodsRepository;
    private AreaRepository areaRepository;
    private UserFilterRepository userFilterRepository;
    private UserOrderRepository userOrderRepository;

    @Autowired
    public ActivityServiceImpl(ActivityRepository activityRepository, ActivityUserRecordRepository activityUserRecordRepository,
                               Type1ActivityRepository type1ActivityRepository, Type2ActivityRepository type2ActivityRepository,
                               AsyncTask asyncTask, IBossService bossService, ProductRepository productRepository,
                               GoodsRepository goodsRepository, AreaRepository areaRepository, UserFilterRepository userFilterRepository,
                               UserOrderRepository userOrderRepository) {
        this.activityRepository = activityRepository;
        this.activityUserRecordRepository = activityUserRecordRepository;
        this.type1Repository = type1ActivityRepository;
        this.type2Repository = type2ActivityRepository;
        this.snowflakeIdWorker = SnowflakeIdWorker.getInstance(1L, 1L);
        this.asyncTask = asyncTask;
        this.bossService = bossService;
        this.productRepository = productRepository;
        this.goodsRepository = goodsRepository;
        this.areaRepository = areaRepository;
        this.userFilterRepository = userFilterRepository;
        this.userOrderRepository = userOrderRepository;
    }

    @Override
    public ActivityTVVO queryActivity(String userId) throws Exception {
        log.info("by luzh: 用户 {} 查询可用的活动信息.", userId);
        CustomerVO customerInfo = bossService.getCustomerInfo(userId).getData();
        Long nowDate = Instant.now().toEpochMilli();
        List<ActivityInfo> activityInfoList =
                activityRepository.findByEffectiveDateLessThanAndExpireDateGreaterThanAndPublish(nowDate, nowDate, true);
        if (activityInfoList.isEmpty()) {
            log.info("by luzh: 没有生效的活动.");
            return null;
        }
        activityInfoList.sort(Comparator.comparing(ActivityInfo::getPriorityLevel).reversed());
        for (ActivityInfo activityInfo : activityInfoList) {
            log.info("by luzh: 开始检查用户 {} 是否满足活动【{}】的参与条件.", userId, activityInfo.getName());
            // 检查用户历史参加记录和是否符合参加条件
            if (checkRecord(activityInfo, userId) && checkActivity(activityInfo, userId, customerInfo)) {
                // 异步线程保存弹窗记录
                Long popTime = Instant.now().toEpochMilli();
                String serialNumber = snowflakeIdWorker.nextId().toString();
                asyncTask.addActivityUserRecord(serialNumber, userId, customerInfo.getCompanyName(), activityInfo, popTime, Globals.COMMON_DATE_FORMATTER.format(LocalDate.now()));
                return createVO(userId, activityInfo, serialNumber, popTime);
            }
        }
        return null;
    }

    /**
     * 体验续订类型弹窗内容有替换变量
     */
    private ActivityTVVO createVO(String userId, ActivityInfo activityInfo, String serialNumber, Long popTime) throws Exception {
        ActivityTVVO activityTVVO = new ActivityTVVO(activityInfo, serialNumber, popTime);
        if (activityInfo.getActivityType().equals(ActivityTypeEnum.TIYAN_XD.getType()) && activityInfo.getIntroduce().contains("YYYYMMDD")) {
            Type2ActivityInfo type2ActivityInfo = getType2ActivityInfo(activityInfo.getId());
            UserOrderInfo userOrderInfo = userOrderRepository.findByUserAndActivityId(userId, type2ActivityInfo.getCorrelationType1ActivityId());
            activityTVVO.setIntroduce(activityTVVO.getIntroduce().replace("YYYYMMDD", Globals.convertDateToChinese(userOrderInfo.getEndDate())));
        }
        return activityTVVO;
    }

    /**
     * 查询用户参加活动的记录
     * 已经参加过或者选择拒绝参加的不再弹窗，考虑一下的情况重新弹窗
     */
    private Boolean checkRecord(ActivityInfo activityInfo, String userId) {
        // hasResponse=true才表示参加活动
        List<ActivityUserRecordInfo> recordInfoList = activityUserRecordRepository.findByActivityIdAndUserIdAndHasResponse(activityInfo.getId(), userId, true);
        if (recordInfoList.isEmpty()) {
            return true;
        }
        recordInfoList.sort(Comparator.comparing(ActivityUserRecordInfo::getResponseTime).reversed());
        ActivityUserRecordInfo recordInfo = recordInfoList.get(0);
        // 用户已经选了立即开通和拒绝则不再弹窗
        log.info("by luzh: 用户已选择 {}.", recordInfo.getResponse());
        return !RESPONSE_AGREE.equals(recordInfo.getResponse()) && !RESPONSE_DISAGREE.equals(recordInfo.getResponse());
    }

    /**
     * 检查当前活动用户是否满足参与条件
     */
    private Boolean checkActivity(ActivityInfo activityInfo, String userId, CustomerVO customerInfo) {
        Boolean result;
        try {
            if (activityInfo.getActivityType().equals(ActivityTypeEnum.TIYAN.getType())) {
                result = checkType1Activity(activityInfo, userId, customerInfo);
            } else if (activityInfo.getActivityType().equals(ActivityTypeEnum.TIYAN_XD.getType())) {
                result = checkType2Activity(activityInfo, userId, customerInfo);
            } else {
                result = false;
            }
        } catch (Exception e) {
            log.error("by luzh: 检查用户是否满足参与条件出现异常:{}", e.getMessage(), e);
            result = false;
        }
        log.info("by luzh: 用户{}活动【{}】的参与条件.", result ? "满足" : "不满足", activityInfo.getName());
        return result;
    }

    /**
     * 检查活动类型1用户是否可以参加
     */
    private Boolean checkType1Activity(ActivityInfo activityInfo, String userId, CustomerVO customerInfo) throws Exception {
        Type1ActivityInfo type1ActivityInfo = getType1ActivityInfo(activityInfo.getId());
        return checkType1ActivityOrderLimit(activityInfo, type1ActivityInfo, customerInfo)
                && checkType1ActivityOrderHistory(activityInfo, type1ActivityInfo, userId)
                && checkType1UserFilter(type1ActivityInfo, userId)
                && checkType1ActivityOrderSituation(activityInfo, type1ActivityInfo, customerInfo);
    }

    private Type1ActivityInfo getType1ActivityInfo(Integer activityId) throws Exception {
        List<Type1ActivityInfo> list = type1Repository.findByActivityId(activityId);
        if (list.isEmpty()) {
            throw new MyCommonException("-1", "系统内部数据错误");
        }
        return list.get(0);
    }

    /**
     * 检查活动类型1是否超过区域限额
     */
    private Boolean checkType1ActivityOrderLimit(ActivityInfo activityInfo, Type1ActivityInfo type1ActivityInfo, CustomerVO customerInfo) {
        if (!type1ActivityInfo.getOpenLimit()) {
            log.info("by luzh: 活动未开启订购限额");
            return true;
        }
        List<ActivityUserRecordInfo> list = activityUserRecordRepository.findByActivityIdAndResponseAndResponseDay(activityInfo.getId(), RESPONSE_AGREE, Globals.COMMON_DATE_FORMATTER.format(LocalDate.now()));
        if (list.size() >= type1ActivityInfo.getLimitNumber()) {
            log.info("by luzh: 开通用户已超出活动限额");
            return false;
        }
        if (type1ActivityInfo.getLimitByArea()) {
            AreaInfo areaInfo = areaRepository.findByAreaName(customerInfo.getCompanyName());
            if (null == areaInfo) {
                log.info("by luzh: 系统内部数据错误-区域信息不存在");
                return false;
            }
            long orderedNumber = list.parallelStream().filter(info -> info.getUserArea().equals(customerInfo.getCompanyName())).count();
            List<AreaLimit> limitList = type1ActivityInfo.getAreaLimits();
            for (AreaLimit limit : limitList) {
                if (limit.getAreaId().equals(areaInfo.getId()) && (limit.getAreaLimitNumber().equals(0) || orderedNumber >= limit.getAreaLimitNumber())) {
                    log.info("by luzh: 开通用户已超出所在分公司限额 or 分公司限额为0");
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 检查用户活动1是否满足历史订购次数限制
     */
    private Boolean checkType1ActivityOrderHistory(ActivityInfo activityInfo, Type1ActivityInfo type1ActivityInfo, String userId) {
        if (activityInfo.getActivityCategory().equals(ActivityCategoryEnum.MIANFEI.getCategory()) && null != type1ActivityInfo.getMaxType1JoinTimes() && type1ActivityInfo.getMaxType1JoinTimes() > 0) {
            List<ActivityUserRecordInfo> recordInfoList =
                    activityUserRecordRepository.findByUserIdAndActivityTypeAndActivityCategoryAndResponse(userId, ActivityTypeEnum.TIYAN.getTypeName(), ActivityCategoryEnum.MIANFEI.getCategory(), RESPONSE_AGREE);
            log.info("by luzh: 用户参与体验类型活动次数{}活动限制参与次数.", recordInfoList.size() <= type1ActivityInfo.getMaxType1JoinTimes() ? "未超出" : "已超出");
            return recordInfoList.size() <= type1ActivityInfo.getMaxType1JoinTimes();
        }
        return true;
    }

    /**
     * 检查活动是否开启过滤名单、用户是否在过滤名单内
     */
    private Boolean checkType1UserFilter(Type1ActivityInfo type1ActivityInfo, String userId) {
        if (type1ActivityInfo.getOpenFilter()) {
            UserFilterInfo userFilterInfo = userFilterRepository.findByUser(userId);
            if (null != userFilterInfo) {
                log.info("by luzh: 活动开启用户过滤名单，用户在名单内.");
            }
            return null == userFilterInfo;
        }
        return true;
    }

    /**
     * 检查用户活动1是否满足订购情况
     */
    private Boolean checkType1ActivityOrderSituation(ActivityInfo activityInfo, Type1ActivityInfo type1ActivityInfo, CustomerVO customerInfo) throws Exception {
        // 活动商品已订购则不参加该活动
        Boolean goodsOrderResult = bossService.checkGoodsOrder(new CheckGoodsOrderReq(customerInfo, activityInfo.getGoodsInfo().getGoodsCode())).getData();
        if (goodsOrderResult) {
            log.info("by luzh: 用户已订购活动商品-{}.", activityInfo.getGoodsInfo().getGoodsName());
            return false;
        }
        List<String> orderedInfo = Type1ActivityUtil.convertMustOrderInfo(type1ActivityInfo);
        List<String> notOrderedInfo = Type1ActivityUtil.convertMustNotOrderInfo(type1ActivityInfo);
        return checkType1MustOrderInfo(type1ActivityInfo, customerInfo, orderedInfo) && checkType1MustNotOrderInfo(type1ActivityInfo, customerInfo, notOrderedInfo);
    }

    private Boolean checkType1MustOrderInfo(Type1ActivityInfo type1ActivityInfo, CustomerVO customerInfo, List<String> orderedInfo) throws Exception {
        for (String mustOrder : orderedInfo) {
            CheckType1Order orderResult = checkOrderStatus(customerInfo,
                    mustOrder,
                    type1ActivityInfo.getMustOrderType());
            // 检查必须已订购的信息，设置检查方式为且，发现有一个未订购立即返回失败
            if (!orderResult.getOrderResult() && type1ActivityInfo.getCheckMustOrderMode().equals("and")) {
                log.info("by luzh: 用户未订购{}-{}.", orderResult.getType(), orderResult.getName());
                return false;
            }
            // 检查必须已订购的信息，设置检查方式为或，发现有一个已订购立即返回成功
            if (orderResult.getOrderResult() && type1ActivityInfo.getCheckMustOrderMode().equals("or")) {
                log.info("by luzh: 用户已订购{}-{}.", orderResult.getType(), orderResult.getName());
                return true;
            }
        }
        return true;
    }

    private Boolean checkType1MustNotOrderInfo(Type1ActivityInfo type1ActivityInfo, CustomerVO customerInfo, List<String> notOrderedInfo) throws Exception {
        for (String mustNotOrdered : notOrderedInfo) {
            CheckType1Order orderResult = checkOrderStatus(customerInfo,
                    mustNotOrdered,
                    type1ActivityInfo.getMustNotOrderType());
            // 检查必须未订购的信息，设置检查方式为且，发现一个已订购立即返回失败
            if (orderResult.getOrderResult() && type1ActivityInfo.getCheckMustNotOrderMode().equals("and")) {
                log.info("by luzh: 用户已订购{}-{}.", orderResult.getType(), orderResult.getName());
                return false;
            }
            // 检查必须未订购的信息，设置检查方式为或，发现一个未订购立即返回成功
            if (!orderResult.getOrderResult() && type1ActivityInfo.getCheckMustNotOrderMode().equals("or")) {
                log.info("by luzh: 用户未订购{}-{}.", orderResult.getType(), orderResult.getName());
                return true;
            }
        }
        return true;
    }

    private CheckType1Order checkOrderStatus(CustomerVO customerInfo, String orderInfoId, String orderInfoType) throws Exception {
        CheckType1Order check = new CheckType1Order();
        Boolean orderResult = null;
        switch (orderInfoType) {
            case Globals.GOODS_EN_NAME:
                GoodsInfo goodsInfo = goodsRepository.findById(Integer.parseInt(orderInfoId)).orElse(null);
                if (null != goodsInfo) {
                    orderResult = bossService.checkGoodsOrder(new CheckGoodsOrderReq(customerInfo, goodsInfo.getGoodsCode())).getData();
                    check.setName(goodsInfo.getGoodsName());
                    check.setType(Globals.GOODS_NAME);
                }
                break;
            case Globals.PRODUCT_EN_NAME:
                ProductInfo productInfo = productRepository.findById(Integer.parseInt(orderInfoId)).orElse(null);
                if (productInfo != null) {
                    orderResult = bossService.checkProductOrder(new CheckProductOrderReq(customerInfo, productInfo.getProductCode(), "0")).getData();
                    check.setName(productInfo.getProductName());
                    check.setType(Globals.PRODUCT_NAME);
                }
                break;
            default:
                break;

        }
        // 未知类型，表示数据库内部数据错误，直接抛出异常处理
        if (null == orderResult) {
            log.error("by luzh: 检查订购数据错误");
            throw new MyCommonException("-111", "检查订购情况时发生数据错误");
        }
        check.setOrderResult(orderResult);
        return check;
    }

    /**
     * 检查活动类型2用户是否可以参加
     */
    private Boolean checkType2Activity(ActivityInfo activityInfo, String userId, CustomerVO customerInfo) throws Exception {
        Type2ActivityInfo type2ActivityInfo = getType2ActivityInfo(activityInfo.getId());
        List<ActivityUserRecordInfo> recordInfoList = activityUserRecordRepository.findByActivityIdAndUserIdAndHasResponse(type2ActivityInfo.getCorrelationType1ActivityId(), userId, true);
        // 活动类型2关联的类型为活动类型1的活动没有参与记录
        if (recordInfoList.isEmpty()) {
            log.info("by luzh: 用户没有参与过已关联的体验类型活动.");
            return false;
        }
        recordInfoList.sort(Comparator.comparing(ActivityUserRecordInfo::getResponseTime).reversed());
        ActivityUserRecordInfo recordInfo = recordInfoList.get(0);
        if (recordInfo.getResponse().equals(RESPONSE_AGREE) && Globals.isEmpty(recordInfo.getResponseResult())) {
            UserOrderInfo userOrderInfo = userOrderRepository.findByRecordId(recordInfo.getId());
            LocalDate orderEndDate = LocalDate.parse(userOrderInfo.getEndDate(), Globals.COMMON_DATE_FORMATTER);
            LocalDate remindDate = null != type2ActivityInfo.getAdvanceRemindDay() && type2ActivityInfo.getAdvanceRemindDay() > 0 ? orderEndDate.minusDays(type2ActivityInfo.getAdvanceRemindDay()) : orderEndDate;
            log.info("by luzh: 订购到期提醒日期为 {}.", remindDate.toString());
            Boolean result = false;
            if (remindDate.isBefore(LocalDate.now()) || remindDate.isEqual(LocalDate.now())) {
                Boolean isMarketing = bossService.checkIsMarketing(new CheckIsMarketingReq(customerInfo, activityInfo.getGoodsInfo().getGoodsCode())).getData();
                log.info("by luzh: 查询是否满足订购校验结果是 {}.", isMarketing ? "满足" : "不满足");
                result = isMarketing;
            }
            return result;
        }
        log.info("by luzh: 用户没有参与过已关联的体验类型活动.");
        return false;
    }

    private Type2ActivityInfo getType2ActivityInfo(Integer activityId) throws Exception {
        List<Type2ActivityInfo> list = type2Repository.findByActivityId(activityId);
        if (list.isEmpty()) {
            throw new MyCommonException("-1", "系统内部数据错误");
        }
        return list.get(0);
    }

    @Override
    public Boolean activityResponse(String serialNumber, String userId, Integer activityId, Long popTime, String response) throws Exception {
        log.info("by luzh: 用户 {} {} 弹窗点击按钮 {}, 弹窗序列号: {}.", userId, Globals.formatterDateTime(popTime), response, serialNumber);
        if (!activityResponse.contains(response)) {
            throw new RequestParamErrorException("响应无效");
        }
        CustomerVO customerInfo = bossService.getCustomerInfo(userId).getData();
        List<ActivityUserRecordInfo> recordInfoList = activityUserRecordRepository.findBySerialNumberAndActivityIdAndUserId(serialNumber, activityId, userId);
        ActivityUserRecordInfo recordInfo = null;
        for (ActivityUserRecordInfo info : recordInfoList) {
            if (info.getPopTime().equals(popTime)) {
                recordInfo = info;
            }
        }
        if (null == recordInfo) {
            throw new RequestParamErrorException("弹窗记录无效");
        }
        if (recordInfo.getHasResponse()) {
            return true;
        }
        ActivityInfo activityInfo = activityRepository.findById(activityId).orElseThrow(() -> new RequestParamErrorException("活动无效"));
        BossOrder bossOrder = new BossOrder();
        bossOrder.setOrderResult("");
        if (RESPONSE_AGREE.equals(response)) {
            bossOrder = openedImmediately(userId, activityInfo, customerInfo);
        }
        recordInfo.setResponseDay(Globals.COMMON_DATE_FORMATTER.format(LocalDate.now()));
        recordInfo.setResponse(response);
        recordInfo.setResponseTime(Instant.now().toEpochMilli());
        recordInfo.setResponseResult(bossOrder.getOrderResult());
        recordInfo.setHasResponse(true);
        activityUserRecordRepository.save(recordInfo);
        // 记录用户订购信息，用作体验续订的到期提醒
        if (Globals.isEmpty(bossOrder.getOrderResult())) {
            if (RESPONSE_AGREE.equals(response)) {
                UserOrderInfo orderInfo = new UserOrderInfo(
                        userId,
                        bossOrder.getOfferId(),
                        bossOrder.getOrderDate(),
                        bossOrder.getEndDate(),
                        recordInfo.getId(),
                        activityId
                );
                userOrderRepository.save(orderInfo);
            }
            return true;
        }
        throw new MyCommonException("-1", bossOrder.getOrderResult());
    }

    /**
     * 参与活动，立即开通
     */
    private BossOrder openedImmediately(String userId, ActivityInfo activityInfo, CustomerVO customerInfo) {
        BossOrder result = new BossOrder();
        try {
            log.info("by luzh: 用户 {} 立即开通 {}.", userId, activityInfo.getName());
            if (activityInfo.getActivityType().equals(ActivityTypeEnum.TIYAN.getType())) {
                result = joinType1Activity(userId, activityInfo, customerInfo);
            } else {
                result = joinType2Activity(userId, activityInfo, customerInfo);
            }
        } catch (Exception e) {
            log.error("by luzh: 开通失败: {}", e.getMessage(), e);
            result.setOrderResult(e.getMessage() + "");
        }
        return result;
    }

    /**
     * 用户参加类型1（体验活动）
     *
     */
    private BossOrder joinType1Activity(String userId, ActivityInfo activityInfo, CustomerVO customerInfo) throws Exception {
        log.info("by luzh: {} 用户 {} 参与 {}: {}", LocalDateTime.now().toString(), userId, ActivityTypeEnum.TIYAN.getTypeName(), activityInfo.getName());
        Type1ActivityInfo type1ActivityInfo = getType1ActivityInfo(activityInfo.getId());
        String startTime = Globals.COMMON_DATE_FORMATTER.format(LocalDate.now());
        String endTime = Globals.COMMON_DATE_FORMATTER.format(DateUtil.getYesterdayOfAFewMonthsLater(LocalDate.now(), type1ActivityInfo.getOrderLength()));
        String operatorCode = ActivityCategoryEnum.MIANFEI.getCategory().equals(activityInfo.getActivityCategory()) ? "DDDDDD" : "BBBBBB";
        return bossOrder(customerInfo, activityInfo, operatorCode, startTime, endTime);
    }

    private BossOrder bossOrder(CustomerVO customerInfo, ActivityInfo activityInfo, String operatorCode, String startTime, String endTime) throws Exception {
        BossOrder bossOrder = new BossOrder();
        bossOrder.setOrderDate(startTime);
        bossOrder.setEndDate(endTime);
        bossOrder.setOfferId(activityInfo.getGoodsInfo().getGoodsCode());
        String result = bossService.buyOffer(
                new BuyOfferReq(
                        customerInfo,
                        activityInfo.getGoodsInfo().getGoodsCode(),
                        operatorCode,
                        startTime,
                        endTime
                )
        ).getData() ? "" : "订购失败";
        bossOrder.setOrderResult(result);
        return bossOrder;
    }

    /**
     * 用户参加类型2（体验活动到期续订活动）
     * 类型2直接进行订购
     */
    private BossOrder joinType2Activity(String userId, ActivityInfo activityInfo, CustomerVO customerInfo) throws Exception {
        log.info("by luzh: {} 用户 {} 参与 {}: {}", LocalDateTime.now().toString(), userId, ActivityTypeEnum.TIYAN_XD.getTypeName(), activityInfo.getName());
        String startTime = Globals.COMMON_DATE_FORMATTER.format(LocalDate.now());
        String endTime = Globals.COMMON_DATE_FORMATTER.format(DateUtil.getYesterdayOfNextMonth(LocalDate.now()));
        String operatorCode = ActivityCategoryEnum.MIANFEI.getCategory().equals(activityInfo.getActivityCategory()) ? "DDDDDD" : "BBBBBB";
        return bossOrder(customerInfo, activityInfo, operatorCode, startTime, endTime);
    }


}