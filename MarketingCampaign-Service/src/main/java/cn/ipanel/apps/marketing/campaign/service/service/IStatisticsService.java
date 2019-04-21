package cn.ipanel.apps.marketing.campaign.service.service;

import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.ActivityStatisticsVO;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/19 下午2:34
 * Modified By:
 * Description:
 */
public interface IStatisticsService {

    ActivityStatisticsVO queryStatisticsInfo(Integer activityId, String startDay, String endDay) throws Exception;
}
