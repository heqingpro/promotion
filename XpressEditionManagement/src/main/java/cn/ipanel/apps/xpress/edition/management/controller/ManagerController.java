package cn.ipanel.apps.xpress.edition.management.controller;

import cn.ipanel.apps.xpress.edition.management.annotation.LogHttpRequestParameter;
import cn.ipanel.apps.xpress.edition.management.annotation.LogHttpRequestResult;
import cn.ipanel.apps.xpress.edition.management.controller.request.ChangePassReq;
import cn.ipanel.apps.xpress.edition.management.controller.request.ManagerReq;
import cn.ipanel.apps.xpress.edition.management.controller.response.Result;
import cn.ipanel.apps.xpress.edition.management.service.IManagerService;
import cn.ipanel.apps.xpress.edition.management.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created with Intellij IDEA.
 *
 * @author luzhihao
 * Create: 2018-05-25 下午3:08
 * Modified By:
 * Description:
 */
@Slf4j
@Controller
@RequestMapping(value = "manager")
public class ManagerController {

    private IManagerService managerService;
    private IRoleService roleService;

    @Autowired
    public ManagerController(IManagerService managerService, IRoleService roleService) {
        this.roleService = roleService;
        this.managerService = managerService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String queryManagers(ModelMap map) {
        try {
            map.addAttribute("managers", managerService.queryManagers());
            map.addAttribute("roles", roleService.queryRoles());
        } catch (Exception e) {
            log.error("{}", e.getMessage(), e);
        }
        return "manager";
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> addManager(@RequestBody ManagerReq req) throws Exception {
        return new Result<>(managerService.addManager(req));
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result<Boolean> updateManager(@PathVariable(value = "id") Integer id, @RequestBody ManagerReq req) throws Exception {
        return new Result<>(managerService.updateManager(id, req));
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result<Boolean> deleteManager(@PathVariable(value = "id") Integer id) {
        return new Result<>(managerService.deleteManager(id));
    }

    @RequestMapping(value = "pass", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> changePass(@RequestBody ChangePassReq req) throws Exception {
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        return new Result<>(managerService.changePass(username, req));
    }
}