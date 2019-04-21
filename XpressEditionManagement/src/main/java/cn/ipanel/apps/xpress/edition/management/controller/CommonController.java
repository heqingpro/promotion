package cn.ipanel.apps.xpress.edition.management.controller;

import cn.ipanel.apps.xpress.edition.management.controller.response.Result;
import cn.ipanel.apps.xpress.edition.management.controller.response.ManagerVO;
import cn.ipanel.apps.xpress.edition.management.global.Globals;
import cn.ipanel.apps.xpress.edition.management.service.IManagerService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with Intellij IDEA.
 *
 * @author luzhihao
 * Create: 2018-05-27 下午11:02
 * Modified By:
 * Description:
 */
@Controller
public class CommonController {

    private IManagerService managerService;

    @Autowired
    public CommonController(IManagerService managerService) {
        this.managerService = managerService;
    }

    @RequestMapping(value = "")
    public String index(ModelMap map) {
        return indexHtml(map, "");
    }

    @RequestMapping(value = "login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "loginSuccess")
    @ResponseBody
    public Result<Boolean> loginSuccess() {
        return new Result<>(true);
    }

    @RequestMapping(value = "index")
    public String indexHtml(ModelMap map, @RequestParam(value = "info", required = false) String info) {
        if (!Globals.isEmpty(info)) {
            System.out.println(info);
        }
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        ManagerVO vo = managerService.queryManager(username);
        if (null == vo) {
            return "login";
        }
        map.addAttribute("name", vo.getName());
        map.addAttribute("roles", vo.getRoles());
        map.addAttribute("time",  Globals.timeQuantum());
        return "index";
    }
}
