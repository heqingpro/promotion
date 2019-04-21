package cn.ipanel.apps.xpress.edition.management.controller;

import cn.ipanel.apps.xpress.edition.management.annotation.LogHttpRequestParameter;
import cn.ipanel.apps.xpress.edition.management.annotation.LogHttpRequestResult;
import cn.ipanel.apps.xpress.edition.management.controller.request.MouldReq;
import cn.ipanel.apps.xpress.edition.management.controller.response.DataTablesVO;
import cn.ipanel.apps.xpress.edition.management.controller.response.MouldBackVO;
import cn.ipanel.apps.xpress.edition.management.controller.response.Result;
import cn.ipanel.apps.xpress.edition.management.feign.IMouldManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/8 下午2:25
 * Modified By:
 * Description:
 */
@Api(tags = "模板管理")
@Slf4j
@Controller
@RequestMapping(value = "window/mould")
public class MouldManageController {

    private IMouldManageService mouldManageService;

    @Autowired
    public MouldManageController(IMouldManageService mouldManageService) {
        this.mouldManageService = mouldManageService;
    }

    @ApiIgnore
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String queryMould(ModelMap map) {
        try {
            List<MouldBackVO> allList = mouldManageService.queryMould().getData();
            map.put("list", allList);
        } catch (Exception e) {
            log.error("{}", e.getMessage(), e);
        }
        return "mould";
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @ApiOperation(value = "添加模板")
    @ApiImplicitParam(name = "req", value = "模板", required = true, dataType = "MouldReq", paramType = "body")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> addMould(@RequestBody MouldReq req) {
        return new Result<>(mouldManageService.addMould(req));
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @ApiOperation(value = "修改模板")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "模板id", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "req", value = "模板", required = true, dataType = "MouldReq", paramType = "body")
    })
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result<Boolean> modifyMould(@PathVariable(value = "id") Integer id, @RequestBody MouldReq req) {
        return new Result<>(mouldManageService.modifyMould(id, req));
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @ApiOperation(value = "删除模板")
    @ApiImplicitParam(name = "id", value = "模板id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result<Boolean> removeMould(@PathVariable(value = "id") Integer id) {
        return new Result<>(mouldManageService.removeMould(id));
    }

    @ApiOperation(value = "查询模板")
    @ApiImplicitParam(name = "id", value = "模板id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<MouldBackVO> queryMould(@PathVariable(value = "id") Integer id) {
        return new Result<>(mouldManageService.queryMould(id));
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @ApiOperation(value = "增加优先级")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "priorityLevel/up/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> priorityLevelUp(@PathVariable(value = "id") Integer id) {
        return new Result<>(mouldManageService.priorityLevelUp(id));
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @ApiOperation(value = "降低优先级")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "priorityLevel/down/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> priorityLevelDown(@PathVariable(value = "id") Integer id) {
        return new Result<>(mouldManageService.priorityLevelDown(id));
    }

    @RequestMapping(value = "priorityLevel", method = RequestMethod.GET)
    @ResponseBody
    public DataTablesVO<MouldBackVO> queryOnline(HttpServletRequest httpServletRequest) {
        String draw = httpServletRequest.getParameter("draw");
        return new DataTablesVO<>(Integer.parseInt(draw), mouldManageService.queryMouldByPriorityLevel().getData());
    }
}
