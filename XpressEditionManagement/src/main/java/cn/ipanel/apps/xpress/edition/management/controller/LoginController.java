package cn.ipanel.apps.xpress.edition.management.controller;

import cn.ipanel.apps.xpress.edition.management.controller.request.LoginReq;
import cn.ipanel.apps.xpress.edition.management.controller.response.Result;
import cn.ipanel.apps.xpress.edition.management.service.IManagerService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with Intellij IDEA.
 *
 * @author luzhihao
 * Create: 2018-05-27 下午5:35
 * Modified By:
 * Description:
 */
@Slf4j
@RequestMapping(value = "auth")
@Controller
public class LoginController {

    private static Gson gson = new Gson();
    private IManagerService managerService;

    @Autowired
    public LoginController(IManagerService managerService) {
        this.managerService = managerService;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> loginPost(@RequestBody LoginReq req) throws Exception {
        try {
            managerService.login(req.getUsername(), req.getPassword());
            return new Result<>(true);
        } catch (Exception e) {
            log.error("{}", e.getMessage());
            return new Result<>(false, e.getMessage());
        }
    }

    @RequestMapping(value = "success")
    public String success(ModelMap map) {
        System.out.println("success");
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        map.addAttribute("name", username);
        return "index";
    }

    @RequestMapping(value = "unauthorized")
    public Result<String> unauthorized() {
        return new Result<>("登录失败");
    }
}
