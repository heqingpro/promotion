package cn.ipanel.apps.interactive.window.service;

import cn.ipanel.apps.interactive.window.controller.resp.MessageVO;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/11 上午9:58
 * Modified By:
 * Description:
 */
public interface IMessageService {
    MessageVO queryUserMessage(String userId) throws Exception;

    Boolean messageResponse(String serialNumber, String userId, Long recordId, Long popTime, String response) throws Exception;
}
