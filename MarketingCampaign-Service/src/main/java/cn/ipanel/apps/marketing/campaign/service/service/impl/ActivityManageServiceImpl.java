package cn.ipanel.apps.marketing.campaign.service.service.impl;

import cn.ipanel.apps.marketing.campaign.service.controller.req.activity.AreaLimitReq;
import cn.ipanel.apps.marketing.campaign.service.controller.req.activity.Type1Req;
import cn.ipanel.apps.marketing.campaign.service.controller.req.activity.Type2Req;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.ActivityBackVO;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.AreaLimitVO;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.Type1ActivityBackVO;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.Type2ActivityBackVO;
import cn.ipanel.apps.marketing.campaign.service.dao.*;
import cn.ipanel.apps.marketing.campaign.service.entity.*;
import cn.ipanel.apps.marketing.campaign.service.global.Globals;
import cn.ipanel.apps.marketing.campaign.service.global.MyCommonException;
import cn.ipanel.apps.marketing.campaign.service.global.RequestParamErrorException;
import cn.ipanel.apps.marketing.campaign.service.service.IActivityManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/16 下午3:18
 * Modified By:
 * Description: 活动管理service
 */
@Slf4j
@Service
public class ActivityManageServiceImpl implements IActivityManageService {

    private static final String ADJUST_PRIORITY_OPERATION_UP = "up";
    private static final String ADJUST_PRIORITY_OPERATION_DOWN = "down";
    private List<String> ADJUST_PRIORITY_OPERATION = Arrays.asList(ADJUST_PRIORITY_OPERATION_UP, ADJUST_PRIORITY_OPERATION_DOWN);

    private ActivityRepository activityRepository;
    private GoodsRepository goodsRepository;
    private Type1ActivityRepository type1ActivityRepository;
    private Type2ActivityRepository type2ActivityRepository;
    private AreaRepository areaRepository;
    private AreaLimitRepository areaLimitRepository;

    @Autowired
    public ActivityManageServiceImpl(ActivityRepository activityRepository, GoodsRepository goodsRepository,
                                     Type1ActivityRepository type1ActivityRepository, Type2ActivityRepository type2ActivityRepository,
                                     AreaRepository areaRepository, AreaLimitRepository areaLimitRepository) {
        this.activityRepository = activityRepository;
        this.goodsRepository = goodsRepository;
        this.type1ActivityRepository = type1ActivityRepository;
        this.type2ActivityRepository = type2ActivityRepository;
        this.areaRepository = areaRepository;
        this.areaLimitRepository = areaLimitRepository;
    }

    @Override
    public List<ActivityBackVO> queryActivity() {
        return ((List<ActivityInfo>) activityRepository.findAll()).stream().map(ActivityBackVO::new).collect(Collectors.toList());
    }

    @Override
    public Type1ActivityBackVO queryType1Activity(Integer activityId) throws Exception {
        ActivityInfo activityInfo = activityRepository.findById(activityId).orElseThrow(() -> new RequestParamErrorException("活动不存在"));
        if (!activityInfo.getActivityType().equals(ActivityTypeEnum.TIYAN.getType())) {
            throw new RequestParamErrorException("类型错误");
        }
        List<Type1ActivityInfo> type1ActivityInfoList = type1ActivityRepository.findByActivityId(activityInfo.getId());
        if (type1ActivityInfoList.isEmpty()) {
            throw new MyCommonException("-1", "系统内部数据错误");
        }
        Type1ActivityInfo type1ActivityInfo = type1ActivityInfoList.get(0);
        List<AreaLimitVO> defaultList = ((List<AreaInfo>) areaRepository.findAll()).stream().map(AreaLimitVO::new).collect(Collectors.toList());
        return new Type1ActivityBackVO(activityInfo, type1ActivityInfo, defaultList);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean addType1Activity(Type1Req type1Req) throws Exception {
        Globals.checkParams(type1Req);
        final Type1Req req = commonType1Check(type1Req);
        ActivityInfo activityInfo = activityRepository.findByName(req.getName());
        if (null != activityInfo) {
            throw new RequestParamErrorException("名称已存在");
        }
        activityInfo = activityRepository.findByCode(req.getCode());
        if (null != activityInfo) {
            throw new RequestParamErrorException("编号已存在");
        }
        GoodsInfo goodsInfo = goodsRepository.findById(req.getGoodsId()).orElseThrow(() -> new RequestParamErrorException("商品不存在"));
        activityInfo = new ActivityInfo(
                req.getName(),
                req.getCode(),
                ActivityTypeEnum.TIYAN.getType(),
                req.getCategory(),
                goodsInfo.getId(),
                Globals.convertTime(req.getEffectiveDate()),
                Globals.convertTime(req.getExpireDate()),
                req.getIntroduce()
        );
        activityInfo = activityRepository.save(activityInfo);
        type1ActivityRepository.save(new Type1ActivityInfo(
                activityInfo.getId(),
                req.getMustOrderType(),
                Type1ActivityUtil.convertMustOrderInfo(req),
                req.getCheckMustOrderMode(),
                req.getMustNotOrderType(),
                Type1ActivityUtil.convertMustNotOrderInfo(req),
                req.getCheckMustNotOrderMode(),
                req.getMaxType1JoinTimes(),
                "true".equals(req.getOpenLimit()),
                req.getLimitNumber(),
                "true".equals(req.getLimitByArea()),
                createLimit(activityInfo.getId(), req.getAreaLimit()),
                req.getOpenFilter(),
                req.getOrderLength()
        ));
        return true;
    }

    private List<AreaLimit> createLimit(Integer activityId, List<AreaLimitReq> limitReqList) {
        List<AreaLimit> limitList = new ArrayList<>();
        limitReqList.forEach(req -> {
            try {
                AreaInfo areaInfo = areaRepository.findById(req.getAreaId()).orElseThrow(() -> new RequestParamErrorException("分公司不存在"));
                AreaLimit areaLimit = areaLimitRepository.findByAreaIdAndActivityId(areaInfo.getId(), activityId);
                if (null == areaLimit) {
                    areaLimit = new AreaLimit(
                            activityId,
                            areaInfo.getId(),
                            req.getAreaLimitNumber()
                    );
                } else {
                    areaLimit.setAreaLimitNumber(req.getAreaLimitNumber());
                }
                areaLimit = areaLimitRepository.save(areaLimit);
                limitList.add(areaLimit);
            } catch (RequestParamErrorException e) {
                log.error("添加活动-分公司订购限额: {}", e.getMessage());
            }
        });
        return limitList;
    }

    private Type1Req commonType1Check(Type1Req req) throws Exception {
        Long effectiveDate = Globals.convertTime(req.getEffectiveDate());
        Long expireDate = Globals.convertTime(req.getExpireDate());
        if (effectiveDate >= expireDate) {
            throw new RequestParamErrorException("请选择正确的生效、失效时间");
        }
        if (req.getOpenLimit().equals("true") && req.getLimitNumber() <= 0) {
            throw new RequestParamErrorException("已开启每日订购限额，请输入正确的限额总数");
        }

        if (req.getLimitByArea().equals("true") ) {
            int total = 0;
            if (null == req.getAreaLimit() || req.getAreaLimit().isEmpty()) {
                throw new RequestParamErrorException("已选择开启区域订购限额，请输入区域限额数量");
            }
            for (AreaLimitReq limitReq : req.getAreaLimit()) {
                total += limitReq.getAreaLimitNumber();
            }
            req.setLimitNumber(total);
        }
        return req;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean modifyType1Activity(Integer activityId, Type1Req type1Req) throws Exception {
        Globals.checkParams(type1Req);
        final Type1Req req = commonType1Check(type1Req);
        ActivityInfo activityInfo = activityRepository.findByName(req.getName());
        if (null != activityInfo && !activityInfo.getId().equals(activityId)) {
            throw new RequestParamErrorException("名称已存在");
        }
        activityInfo = activityRepository.findByCode(req.getCode());
        if (null != activityInfo && !activityInfo.getId().equals(activityId)) {
            throw new RequestParamErrorException("编号已存在");
        }
        GoodsInfo goodsInfo = goodsRepository.findById(req.getGoodsId()).orElseThrow(() -> new RequestParamErrorException("商品不存在"));
        activityInfo = activityRepository.findById(activityId).orElseThrow(() -> new RequestParamErrorException("活动不存在"));
        List<Type1ActivityInfo> type1ActivityInfoList = type1ActivityRepository.findByActivityId(activityInfo.getId());
        if (type1ActivityInfoList.isEmpty()) {
            throw new MyCommonException("-1", "系统内部数据错误");
        }
        activityInfo = new ActivityInfo(
                req.getName(),
                req.getCode(),
                ActivityTypeEnum.TIYAN.getType(),
                req.getCategory(),
                goodsInfo.getId(),
                Globals.convertTime(req.getEffectiveDate()),
                Globals.convertTime(req.getExpireDate()),
                req.getIntroduce(),
                activityInfo.getPublish(),
                activityInfo.getPriorityLevel()
        );
        activityInfo.setId(activityId);
        activityRepository.save(activityInfo);
        Type1ActivityInfo type1ActivityInfo = type1ActivityInfoList.get(0);
        type1ActivityInfo.setMustOrderType(req.getMustOrderType());
        type1ActivityInfo.setMustOrderedInfo(Type1ActivityUtil.convertMustOrderInfo(req));
        type1ActivityInfo.setCheckMustOrderMode(req.getCheckMustOrderMode());
        type1ActivityInfo.setMustNotOrderType(req.getMustNotOrderType());
        type1ActivityInfo.setMustNotOrderedInfo(Type1ActivityUtil.convertMustNotOrderInfo(req));
        type1ActivityInfo.setCheckMustNotOrderMode(req.getCheckMustNotOrderMode());
        type1ActivityInfo.setMaxType1JoinTimes(req.getMaxType1JoinTimes());
        type1ActivityInfo.setOpenLimit("true".equals(req.getOpenLimit()));
        type1ActivityInfo.setLimitNumber(req.getLimitNumber());
        type1ActivityInfo.setLimitByArea("true".equals(req.getLimitByArea()));
        type1ActivityInfo.setAreaLimits(createLimit(activityInfo.getId(), req.getAreaLimit()));
        type1ActivityInfo.setOpenFilter(req.getOpenFilter());
        type1ActivityInfo.setOrderLength(req.getOrderLength());
        type1ActivityRepository.save(type1ActivityInfo);
        return true;
    }

    @Override
    public Boolean removeType1Activity(Integer activityId) throws Exception {
        ActivityInfo activityInfo = activityRepository.findById(activityId).orElseThrow(() -> new RequestParamErrorException("请求无效"));
        activityRepository.delete(activityInfo);
        List<Type1ActivityInfo> activityInfoList = type1ActivityRepository.findByActivityId(activityId);
        activityInfoList.parallelStream().forEach(type1ActivityInfo -> type1ActivityRepository.delete(type1ActivityInfo));
        return true;
    }

    @Override
    public Type2ActivityBackVO queryType2Activity(Integer activityId) throws Exception {
        ActivityInfo activityInfo = activityRepository.findById(activityId).orElseThrow(() -> new RequestParamErrorException("活动不存在"));
        if (!activityInfo.getActivityType().equals(ActivityTypeEnum.TIYAN_XD.getType())) {
            throw new RequestParamErrorException("类型错误");
        }
        List<Type2ActivityInfo> type2ActivityInfoList = type2ActivityRepository.findByActivityId(activityInfo.getId());
        if (type2ActivityInfoList.isEmpty()) {
            throw new MyCommonException("-1", "系统内部数据错误");
        }
        Type2ActivityInfo type2ActivityInfo = type2ActivityInfoList.get(0);
        return new Type2ActivityBackVO(activityInfo, type2ActivityInfo);
    }

    @Override
    public Boolean addType2Activity(Type2Req req) throws Exception {
        Globals.checkParams(req);
        if (null != req.getAdvanceRemindDay() && req.getAdvanceRemindDay() >= 15) {
            throw new RequestParamErrorException("到期续订提前提醒天数不得大于15天");
        }
        Long effectiveDate = Globals.convertTime(req.getEffectiveDate());
        Long expireDate = Globals.convertTime(req.getExpireDate());
        if (effectiveDate >= expireDate) {
            throw new RequestParamErrorException("请选择正确的生效、失效时间");
        }
        ActivityInfo activityInfo = activityRepository.findByName(req.getName());
        if (null != activityInfo) {
            throw new RequestParamErrorException("名称已存在");
        }
        activityInfo = activityRepository.findByCode(req.getCode());
        if (null != activityInfo) {
            throw new RequestParamErrorException("编号已存在");
        }
        activityRepository.findById(req.getCorrelationType1ActivityId()).orElseThrow(() -> new RequestParamErrorException("关联体验类型活动不存在"));
        GoodsInfo goodsInfo = goodsRepository.findById(req.getGoodsId()).orElseThrow(() -> new RequestParamErrorException("商品不存在"));
        activityInfo = new ActivityInfo(
                req.getName(),
                req.getCode(),
                ActivityTypeEnum.TIYAN_XD.getType(),
                req.getCategory(),
                goodsInfo.getId(),
                Globals.convertTime(req.getEffectiveDate()),
                Globals.convertTime(req.getExpireDate()),
                req.getIntroduce()
        );
        activityInfo = activityRepository.save(activityInfo);
        type2ActivityRepository.save(new Type2ActivityInfo(
                activityInfo.getId(),
                req.getCorrelationType1ActivityId(),
                req.getAdvanceRemindDay()
        ));
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean modifyType2Activity(Integer activityId, Type2Req req) throws Exception {
        Globals.checkParams(req);
        if (null != req.getAdvanceRemindDay() && req.getAdvanceRemindDay() > 15) {
            throw new RequestParamErrorException("到期续订提前提醒天数不得大于15天");
        }
        Long effectiveDate = Globals.convertTime(req.getEffectiveDate());
        Long expireDate = Globals.convertTime(req.getExpireDate());
        if (effectiveDate >= expireDate) {
            throw new RequestParamErrorException("请选择正确的生效、失效时间");
        }
        ActivityInfo activityInfo = activityRepository.findByName(req.getName());
        if (null != activityInfo && !activityInfo.getId().equals(activityId)) {
            throw new RequestParamErrorException("名称已存在");
        }
        activityInfo = activityRepository.findByCode(req.getCode());
        if (null != activityInfo && !activityInfo.getId().equals(activityId)) {
            throw new RequestParamErrorException("编号已存在");
        }
        activityRepository.findById(req.getCorrelationType1ActivityId()).orElseThrow(() -> new RequestParamErrorException("关联体验类型活动不存在"));
        GoodsInfo goodsInfo = goodsRepository.findById(req.getGoodsId()).orElseThrow(() -> new RequestParamErrorException("商品不存在"));
        activityInfo = activityRepository.findById(activityId).orElseThrow(() -> new RequestParamErrorException("活动不存在"));
        List<Type2ActivityInfo> type2ActivityInfoList = type2ActivityRepository.findByActivityId(activityInfo.getId());
        if (type2ActivityInfoList.isEmpty()) {
            throw new MyCommonException("-1", "系统内部数据错误");
        }
        activityInfo = new ActivityInfo(
                req.getName(),
                req.getCode(),
                ActivityTypeEnum.TIYAN_XD.getType(),
                req.getCategory(),
                goodsInfo.getId(),
                Globals.convertTime(req.getEffectiveDate()),
                Globals.convertTime(req.getExpireDate()),
                req.getIntroduce(),
                activityInfo.getPublish(),
                activityInfo.getPriorityLevel()
        );
        activityInfo.setId(activityId);
        activityRepository.save(activityInfo);
        Type2ActivityInfo type2ActivityInfo = type2ActivityInfoList.get(0);
        type2ActivityInfo.setAdvanceRemindDay(req.getAdvanceRemindDay());
        type2ActivityInfo.setCorrelationType1ActivityId(req.getCorrelationType1ActivityId());
        type2ActivityRepository.save(type2ActivityInfo);
        return true;
    }

    @Override
    public Boolean removeType2Activity(Integer activityId) throws Exception {
        ActivityInfo activityInfo = activityRepository.findById(activityId).orElseThrow(() -> new RequestParamErrorException("请求无效"));
        activityRepository.delete(activityInfo);
        List<Type2ActivityInfo> activityInfoList = type2ActivityRepository.findByActivityId(activityId);
        activityInfoList.parallelStream().forEach(type2ActivityInfo -> type2ActivityRepository.delete(type2ActivityInfo));
        return true;
    }

    @Override
    public Boolean online(Integer activityId) throws Exception {
        ActivityInfo activityInfo = activityRepository.findById(activityId).orElseThrow(() -> new RequestParamErrorException("活动无效"));
        if (activityInfo.getActivityType().equals(ActivityTypeEnum.TIYAN.getType())) {
            List<ActivityInfo> activityInfoList = activityRepository.findByActivityTypeAndPublish(activityInfo.getActivityType(), true);
            if (activityInfoList.isEmpty()) {
                online(activityInfo);
                return true;
            }
            throw new MyCommonException("-1", "体验活动类型已有一个上线活动，暂时无法设置多个活动同时上线");
        } else if (activityInfo.getActivityType().equals(ActivityTypeEnum.TIYAN_XD.getType())) {
            online(activityInfo);
            return true;
        }
        return true;
    }

    /**
     * 上线之后优先级设置到最高
     * @param activityInfo 活动信息
     */
    private void online(ActivityInfo activityInfo) {
        List<ActivityInfo> onlineList = activityRepository.findByPublish(true);
        onlineList.sort(Comparator.comparing(ActivityInfo::getPriorityLevel).reversed());
        activityInfo.setPublish(true);
        //当前优先级最高者+1
        activityInfo.setPriorityLevel(onlineList.isEmpty() ? 1 : onlineList.get(0).getPriorityLevel() + 1);
        activityRepository.save(activityInfo);
    }

    @Override
    public Boolean offline(Integer activityId) throws Exception {
        ActivityInfo activityInfo = activityRepository.findById(activityId).orElseThrow(() -> new RequestParamErrorException("活动无效"));
        // 下线之后优先级设置为0
        activityInfo.setPriorityLevel(0);
        activityInfo.setPublish(false);
        activityRepository.save(activityInfo);
        return true;
    }

    @Override
    public Boolean adjustPriority(Integer activityId, String operation) throws Exception {
        if (!ADJUST_PRIORITY_OPERATION.contains(operation)) {
            throw new RequestParamErrorException("错误的操作");
        }
        ActivityInfo activityInfo = activityRepository.findById(activityId).orElseThrow(() -> new RequestParamErrorException("活动无效"));
        if (!activityInfo.getPublish()) {
            throw new RequestParamErrorException("活动未上线");
        }
        List<ActivityInfo> onlineList = activityRepository.findByPublish(true);
        if (ADJUST_PRIORITY_OPERATION_UP.equals(operation)) {
            onlineList = onlineList.stream()
                    .filter(info -> info.getPriorityLevel() > activityInfo.getPriorityLevel())
                    .sorted(Comparator.comparing(ActivityInfo::getPriorityLevel))
                    .collect(Collectors.toList());
        } else if (ADJUST_PRIORITY_OPERATION_DOWN.equals(operation)) {
            onlineList = onlineList.stream()
                    .filter(info -> info.getPriorityLevel() < activityInfo.getPriorityLevel())
                    .sorted(Comparator.comparing(ActivityInfo::getPriorityLevel).reversed())
                    .collect(Collectors.toList());
        }
        if (onlineList.isEmpty()) {
            return true;
        }
        ActivityInfo targetActivityInfo = onlineList.get(0);
        targetActivityInfo.setPriorityLevel(targetActivityInfo.getPriorityLevel() + activityInfo.getPriorityLevel());
        activityInfo.setPriorityLevel(targetActivityInfo.getPriorityLevel() - activityInfo.getPriorityLevel());
        targetActivityInfo.setPriorityLevel(targetActivityInfo.getPriorityLevel() - activityInfo.getPriorityLevel());
        activityRepository.save(targetActivityInfo);
        activityRepository.save(activityInfo);
        return true;
    }

    @Override
    public List<ActivityBackVO> queryOnline() {
        List<ActivityInfo> activityInfoList = activityRepository.findByPublish(true);
        return activityInfoList.stream().map(ActivityBackVO::new).sorted(Comparator.comparing(ActivityBackVO::getPriorityLevel).reversed()).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 5, 6, 9);
        list.sort(Comparator.comparing(Integer::intValue));
        System.out.println(list.get(0));
    }
}
