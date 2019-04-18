package cn.ipanel.apps.interactive.window.task;

import cn.ipanel.apps.interactive.window.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/19 下午2:14
 * Modified By:
 * Description:
 */
@Component
@Slf4j
public class AsyncTask {

    private IMessageService messageService;

    @Autowired
    public AsyncTask(IMessageService messageService) {
        this.messageService = messageService;
    }

    @Async("myAsync")
    public void messageResponse(String serialNumber, String userId, Long recordId, Long popTime, String response) {
        try {
            messageService.messageResponse(serialNumber, userId, recordId, popTime, response);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("message response error: {} {} {} {} {} {}", serialNumber, userId, recordId, popTime, response, e.getMessage(), e);
        }
    }
}
