package cn.ipanel.apps.marketing.campaign.service;

import cn.ipanel.apps.marketing.campaign.service.service.IDataUpdateService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/30 下午5:57
 * Modified By:
 * Description:
 */
@Component
@Order(value = 1)
public class StartUpRunner implements CommandLineRunner {

    @Resource
    private IDataUpdateService dataUpdateService;

    @Override
    public void run(String... args) throws Exception {
        // 数据表结构修改后的数据恢复，按照先后顺序依次执行
        dataUpdateService.initUserOrderInfo();
        dataUpdateService.initType1CheckMode();
        dataUpdateService.initUserRecordActivityCategory();
    }
}
