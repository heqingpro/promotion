package cn.ipanel.apps.marketing.campaign.service.dao;

import cn.ipanel.apps.marketing.campaign.service.entity.ActivityInfo;
import cn.ipanel.apps.marketing.campaign.service.entity.ActivityUserRecordInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/15 下午2:22
 * Modified By:
 * Description:
 */
@Repository
public interface ActivityUserRecordRepository extends CrudRepository<ActivityUserRecordInfo, Long> {

    /**
     * 查询某个特定的弹窗记录
     * @param serialNumber 序列号
     * @param activityId 活动id
     * @param userId 用户CA卡
     * @return info
     */
    List<ActivityUserRecordInfo> findBySerialNumberAndActivityIdAndUserId(String serialNumber, Integer activityId, String userId);

    List<ActivityUserRecordInfo> findByActivityIdAndUserIdAndHasResponse(Integer activityId, String userId, Boolean hasResponse);

    /**
     * 查询用户某个类型的开通次数
     * @param userId 用户CA卡
     * @param activityType 活动类型
     * @param response 参与情况
     * @return list
     */
    List<ActivityUserRecordInfo> findByUserIdAndActivityTypeAndActivityCategoryAndResponse(String userId, String activityType, String activityCategory, String response);

    List<ActivityUserRecordInfo> findByActivityIdAndResponseAndResponseDay(Integer activityId, String response, String responseDay);

    List<ActivityUserRecordInfo> findByActivityIdAndPopTimeGreaterThanEqualAndPopTimeLessThanEqual(Integer activityId, Long greater, Long less);
}
