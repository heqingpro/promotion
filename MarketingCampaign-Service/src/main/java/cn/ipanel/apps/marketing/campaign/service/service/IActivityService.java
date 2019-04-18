package cn.ipanel.apps.marketing.campaign.service.service;

import cn.ipanel.apps.marketing.campaign.service.controller.resp.tv.ActivityTVVO;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/14 下午4:55
 * Modified By:
 * Description:
 */
public interface IActivityService {

    /**
     * 查询用户符合参加条件的活动
     * @param userId 用户CA卡
     * @return 活动
     * @throws Exception e
     */
    ActivityTVVO queryActivity(String userId) throws Exception;

    /**
     * 用户活动弹窗响应
     * @param serialNumber 弹窗序列号
     * @param userId 用户CA卡
     * @param activityId 活动ID
     * @param popTime 弹窗时间
     * @param response 响应动作
     * @return 响应结果，如果为空字符串表示成功，如果是非空表示失败
     * @throws Exception e
     */
    Boolean activityResponse(String serialNumber, String userId, Integer activityId, Long popTime, String response) throws Exception;
}
