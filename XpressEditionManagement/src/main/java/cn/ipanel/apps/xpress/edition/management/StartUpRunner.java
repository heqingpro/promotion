package cn.ipanel.apps.xpress.edition.management;

import cn.ipanel.apps.xpress.edition.management.service.IManagerService;
import cn.ipanel.apps.xpress.edition.management.service.IRoleService;
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
    private IManagerService managerService;

    @Resource
    private IRoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        roleService.initRoles();
        managerService.initAdmin();
    }
}
