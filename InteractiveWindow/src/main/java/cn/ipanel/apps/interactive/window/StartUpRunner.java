package cn.ipanel.apps.interactive.window;

import cn.ipanel.apps.interactive.window.service.IDataUpdateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created with Intellij IDEA.
 *
 * @author luzhihao
 * Create: 2018-05-25 上午11:23
 * Modified By:
 * Description:
 */
@Slf4j
@Component
@Order(value = 1)
public class StartUpRunner implements CommandLineRunner {

    @Resource
    private IDataUpdateService dataUpdateService;

    @Override
    public void run(String... args) throws Exception {
        dataUpdateService.updateEffectiveDateAndPriority();
        dataUpdateService.updateUserMessage();
        dataUpdateService.updateUserRecordMessage();
        dataUpdateService.updateMouldTitle();
    }
}
