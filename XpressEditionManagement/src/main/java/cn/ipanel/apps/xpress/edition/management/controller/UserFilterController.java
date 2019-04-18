package cn.ipanel.apps.xpress.edition.management.controller;

import cn.ipanel.apps.xpress.edition.management.annotation.LogHttpRequestParameter;
import cn.ipanel.apps.xpress.edition.management.annotation.LogHttpRequestResult;
import cn.ipanel.apps.xpress.edition.management.controller.response.Result;
import cn.ipanel.apps.xpress.edition.management.feign.IUserFilterService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/20 上午10:47
 * Modified By:
 * Description:
 */
@Slf4j
@Controller
@RequestMapping(value = "activity/filter")
public class UserFilterController {

    private IUserFilterService userFilterService;

    @Autowired
    public UserFilterController(IUserFilterService userFilterService) {
        this.userFilterService = userFilterService;
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @ApiOperation(value = "添加")
    @ApiImplicitParam(name = "user", value = "用户CA卡", required = true, dataTypeClass = String.class, paramType = "query")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> addUser(@RequestParam(value = "user") String user) {
        return new Result<>(userFilterService.addUser(user));
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @ApiOperation(value = "修改")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "id", required = true, dataTypeClass = Integer.class, paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户CA卡", required = true, dataTypeClass = String.class, paramType = "query")
    })
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result<Boolean> modifyUser(@PathVariable(value = "id") Integer id, String user) {
        log.info("user:{}", user);
        return new Result<>(userFilterService.modifyUser(id, user));
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @ApiOperation(value = "删除")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataTypeClass = Integer.class, paramType = "path")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result<Boolean> removeUser(@PathVariable(value = "id") Integer id) {
        return new Result<>(userFilterService.removeUser(id));
    }

    @ApiOperation(value = "查询列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String queryFilterList(ModelMap map) {
        try {
            map.put("list", userFilterService.queryFilterList().getData());
        } catch (Exception e) {
            log.error("{}", e.getMessage(), e);
        }
        return "activity_filter";
    }
}
