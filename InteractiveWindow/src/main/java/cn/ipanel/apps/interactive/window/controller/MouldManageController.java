package cn.ipanel.apps.interactive.window.controller;

import cn.ipanel.apps.interactive.window.controller.req.MouldReq;
import cn.ipanel.apps.interactive.window.controller.resp.Result;
import cn.ipanel.apps.interactive.window.controller.resp.back.MouldBackVO;
import cn.ipanel.apps.interactive.window.global.Globals;
import cn.ipanel.apps.interactive.window.service.IMouldManageService;
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
 * Create: 2018/10/8 上午11:12
 * Modified By:
 * Description:
 */
@Api(tags = Globals.API_BACK)
@RestController
@RequestMapping(value = "manage/mould")
public class MouldManageController {

    private IMouldManageService mouldManageService;

    @Autowired
    public MouldManageController(IMouldManageService mouldManageService) {
        this.mouldManageService = mouldManageService;
    }

    @ApiOperation(value = "添加模板")
    @ApiImplicitParam(name = "req", value = "模板", required = true, dataType = "MouldReq", paramType = "body")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Result<Boolean> addMould(@RequestBody MouldReq req) throws Exception {
        return new Result<>(mouldManageService.addMould(req));
    }

    @ApiOperation(value = "修改模板")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "模板id", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "req", value = "模板", required = true, dataType = "MouldReq", paramType = "body")
    })
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Result<Boolean> modifyMould(@PathVariable(value = "id") Integer id, @RequestBody MouldReq req) throws Exception {
        return new Result<>(mouldManageService.modifyMould(id, req));
    }

    @ApiOperation(value = "删除模板")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Result<Boolean> removeMould(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(mouldManageService.removeMould(id));
    }

    @ApiOperation(value = "查询模板")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result<List<MouldBackVO>> queryMould() {
        return new Result<>(mouldManageService.queryMould());
    }

    @ApiImplicitParam(name = "id", value = "模板id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Result<MouldBackVO> queryMould(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(mouldManageService.queryMould(id));
    }

    @ApiOperation(value = "增加优先级")
    @ApiImplicitParam(name = "id", value = "模板id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "priorityLevel/up/{id}", method = RequestMethod.POST)
    public Result<Boolean> priorityLevelUp(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(mouldManageService.adjustPriority(id, "up"));
    }

    @ApiOperation(value = "减小优先级")
    @ApiImplicitParam(name = "id", value = "模板id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "priorityLevel/down/{id}", method = RequestMethod.POST)
    public Result<Boolean> priorityLevelDown(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(mouldManageService.adjustPriority(id, "down"));
    }

    @ApiOperation(value = "按照优先级查询模板列表")
    @RequestMapping(value = "priorityLevel", method = RequestMethod.GET)
    public Result<List<MouldBackVO>> priorityLevel() {
        return new Result<>(mouldManageService.queryMouldByPriorityLevel());
    }
}