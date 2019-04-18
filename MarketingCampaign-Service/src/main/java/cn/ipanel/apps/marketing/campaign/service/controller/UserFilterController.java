package cn.ipanel.apps.marketing.campaign.service.controller;

import cn.ipanel.apps.marketing.campaign.service.controller.resp.Result;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.UserFilterVO;
import cn.ipanel.apps.marketing.campaign.service.global.Globals;
import cn.ipanel.apps.marketing.campaign.service.service.IUserFilterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/20 上午10:47
 * Modified By:
 * Description:
 */
@Api(tags = Globals.API_BACK)
@RestController
@RequestMapping(value = "user/filter")
public class UserFilterController {

    private IUserFilterService userFilterService;

    @Autowired
    public UserFilterController(IUserFilterService userFilterService) {
        this.userFilterService = userFilterService;
    }

    @ApiOperation(value = "添加")
    @ApiImplicitParam(name = "user", value = "用户CA卡", required = true, dataTypeClass = String.class, paramType = "query")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Result<Boolean> addUser(@RequestParam(value = "user") String user) throws Exception {
        return new Result<>(userFilterService.addUser(user));
    }

    @ApiOperation(value = "修改")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "id", required = true, dataTypeClass = Integer.class, paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户CA卡", required = true, dataTypeClass = String.class, paramType = "query")
    })
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Result<Boolean> modifyUser(@PathVariable(value = "id") Integer id, @RequestParam(value = "user") String user) throws Exception {
        return new Result<>(userFilterService.modifyUser(id, user));
    }

    @ApiOperation(value = "删除")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataTypeClass = Integer.class, paramType = "path")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Result<Boolean> removeUser(@PathVariable(value = "id") Integer id) {
        return new Result<>(userFilterService.removeUser(id));
    }

    @ApiOperation(value = "查询列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result<List<UserFilterVO>> queryFilterList() {
        return new Result<>(userFilterService.queryFilterList());
    }
}
