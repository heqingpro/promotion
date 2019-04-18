package cn.ipanel.apps.xpress.edition.boss;

import cn.ipanel.apps.xpress.edition.boss.global.MyCommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/30 下午2:03
 * Modified By:
 * Description:
 */
@Slf4j
@Component
@Order(value = 1)
public class StartUpRunner implements CommandLineRunner {

    @Value("${boss.url}")
    private String bossUrl;


    @Override
    public void run(String... args) throws Exception {
        if (bossUrl.isEmpty()) {
            log.error("boss接口地址必须设置");
            throw new MyCommonException("-1", "boss接口地址必须设置");
        }
    }
}
