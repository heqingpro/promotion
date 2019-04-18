package cn.ipanel.apps.interactive.window.service;

import cn.ipanel.apps.interactive.window.controller.resp.back.MouldStatisticsVO;
import cn.ipanel.apps.interactive.window.controller.resp.back.UserMessageVO;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/18 上午11:48
 * Modified By:
 * Description:
 */
public interface IStatisticsService {
    MouldStatisticsVO queryStatisticsInfo(Integer mouldId, String startDay, String endDay) throws Exception;

    List<UserMessageVO> queryUserMessage(String user);
}
