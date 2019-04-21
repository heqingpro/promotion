package cn.ipanel.apps.marketing.campaign.service.service.impl;

import cn.ipanel.apps.marketing.campaign.service.dao.ActivityRepository;
import cn.ipanel.apps.marketing.campaign.service.dao.ActivityUserRecordRepository;
import cn.ipanel.apps.marketing.campaign.service.dao.Type1ActivityRepository;
import cn.ipanel.apps.marketing.campaign.service.dao.UserOrderRepository;
import cn.ipanel.apps.marketing.campaign.service.entity.ActivityInfo;
import cn.ipanel.apps.marketing.campaign.service.entity.ActivityUserRecordInfo;
import cn.ipanel.apps.marketing.campaign.service.entity.Type1ActivityInfo;
import cn.ipanel.apps.marketing.campaign.service.entity.UserOrderInfo;
import cn.ipanel.apps.marketing.campaign.service.global.Globals;
import cn.ipanel.apps.marketing.campaign.service.service.IDataUpdateService;
import cn.ipanel.apps.marketing.campaign.service.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static cn.ipanel.apps.marketing.campaign.service.service.impl.ActivityServiceImpl.RESPONSE_AGREE;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/10 上午9:24
 * Modified By:
 * Description: 数据更新
 */
@Slf4j
@Service
public class DataUpdateServiceImpl implements IDataUpdateService {

    private ActivityUserRecordRepository activityUserRecordRepository;

    private UserOrderRepository userOrderRepository;

    private ActivityRepository activityRepository;

    private Type1ActivityRepository type1ActivityRepository;

    @Autowired
    public DataUpdateServiceImpl(ActivityUserRecordRepository activityUserRecordRepository, ActivityRepository activityRepository,
                                 UserOrderRepository userOrderRepository, Type1ActivityRepository type1ActivityRepository) {
        this.activityUserRecordRepository = activityUserRecordRepository;
        this.activityRepository = activityRepository;
        this.userOrderRepository = userOrderRepository;
        this.type1ActivityRepository = type1ActivityRepository;
    }

    @Override
    // 中途修改过逻辑，新增了一个表，需要从弹窗按钮统计数据中获取有效数据生成到表中
    public void initUserOrderInfo() {
        List<ActivityUserRecordInfo> list = (List<ActivityUserRecordInfo>) activityUserRecordRepository.findAll();
        list.forEach(info -> {
            if (null != info.getResponse() && info.getResponse().equals(RESPONSE_AGREE) && Globals.isEmpty(info.getResponseResult())) {
                UserOrderInfo userOrderInfo = userOrderRepository.findByUserAndRecordId(info.getUserId(), info.getId());
                if (null == userOrderInfo) {
                    Optional<ActivityInfo> activityInfo = activityRepository.findById(info.getActivityId());
                    activityInfo.ifPresent(activityInfo1 -> {
                        LocalDateTime orderDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(info.getResponseTime()), Globals.getSystemDefaultZoneOffSet());
                        UserOrderInfo userOrderInfo1 = new UserOrderInfo();
                        userOrderInfo1.setGoodsCode(activityInfo1.getGoodsInfo().getGoodsCode());
                        userOrderInfo1.setActivityId(activityInfo1.getId());
                        userOrderInfo1.setRecordId(info.getId());
                        userOrderInfo1.setUser(info.getUserId());
                        userOrderInfo1.setOrderDate(info.getPopDay());
                        // 旧的代码体验活动立即订购的时候是一个月
                        userOrderInfo1.setEndDate(Globals.COMMON_DATE_FORMATTER.format(DateUtil.getYesterdayOfNextMonth(orderDateTime.toLocalDate())));
                        userOrderRepository.save(userOrderInfo1);
                    });
                }
            }
        });
    }

    @Override
    public void initType1CheckMode() {
        List<Type1ActivityInfo> list = (List<Type1ActivityInfo>) type1ActivityRepository.findAll();
        list.forEach(info -> {
            if (null == info.getCheckMustOrderMode()) {
                info.setCheckMustOrderMode("and");
            }
            if (null == info.getCheckMustNotOrderMode()) {
                info.setCheckMustNotOrderMode("and");
            }
            type1ActivityRepository.save(info);
        });
    }

    @Override
    public void initUserRecordActivityCategory() {
        List<ActivityUserRecordInfo> list = (List<ActivityUserRecordInfo>) activityUserRecordRepository.findAll();
        list.forEach(info -> {
            if (null == info.getActivityCategory()) {
                activityRepository.findById(info.getActivityId()).ifPresent(activityInfo -> {
                    info.setActivityCategory(activityInfo.getActivityCategory());
                    activityUserRecordRepository.save(info);
                });
            }
        });
    }
}
