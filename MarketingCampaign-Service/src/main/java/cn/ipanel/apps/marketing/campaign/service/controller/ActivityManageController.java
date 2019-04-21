package cn.ipanel.apps.marketing.campaign.service.controller;

import cn.ipanel.apps.marketing.campaign.service.controller.req.activity.Type1Req;
import cn.ipanel.apps.marketing.campaign.service.controller.req.activity.Type2Req;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.Result;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.ActivityBackVO;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.Type1ActivityBackVO;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.Type2ActivityBackVO;
import cn.ipanel.apps.marketing.campaign.service.global.Globals;
import cn.ipanel.apps.marketing.campaign.service.service.IActivityManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/16 下午3:36
 * Modified By:
 * Description:
 */
@Slf4j
@Api(tags = Globals.API_BACK)
@RestController
@RequestMapping(value = "/manage/activity")
public class ActivityManageController {

    private IActivityManageService activityManageService;

    @Autowired
    public ActivityManageController(IActivityManageService activityManageService) {
        this.activityManageService = activityManageService;
    }

    @ApiOperation(value = "查询活动列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result<List<ActivityBackVO>> queryActivity() {
        return new Result<>(activityManageService.queryActivity());
    }

    @ApiOperation(value = "查询类型1的活动信息")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "type1/{id}", method = RequestMethod.GET)
    public Result<Type1ActivityBackVO> queryType1Activity(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(activityManageService.queryType1Activity(id));
    }

    @ApiOperation(value = "添加活动类型1")
    @RequestMapping(value = "type1", method = RequestMethod.POST)
    public Result<Boolean> addType1Activity(@RequestBody Type1Req req) throws Exception {
        return new Result<>(activityManageService.addType1Activity(req));
    }

    @ApiOperation(value = "修改活动类型1")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "type1/{id}", method = RequestMethod.PUT)
    public Result<Boolean> modifyType1Activity(@PathVariable(value = "id") Integer id, @RequestBody Type1Req req) throws Exception {
        return new Result<>(activityManageService.modifyType1Activity(id, req));
    }

    @ApiOperation(value = "删除活动类型1")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "type1/{id}", method = RequestMethod.DELETE)
    public Result<Boolean> removeType1Activity(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(activityManageService.removeType1Activity(id));
    }

    @ApiOperation(value = "查询类型2的活动信息")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "type2/{id}", method = RequestMethod.GET)
    public Result<Type2ActivityBackVO> queryType2Activity(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(activityManageService.queryType2Activity(id));
    }

    @ApiOperation(value = "添加活动类型2")
    @RequestMapping(value = "type2", method = RequestMethod.POST)
    public Result<Boolean> addType2Activity(@RequestBody Type2Req req) throws Exception {
        return new Result<>(activityManageService.addType2Activity(req));
    }

    @ApiOperation(value = "修改活动类型2")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "type2/{id}", method = RequestMethod.PUT)
    public Result<Boolean> modifyType2Activity(@PathVariable(value = "id") Integer id, @RequestBody Type2Req req) throws Exception {
        return new Result<>(activityManageService.modifyType2Activity(id, req));
    }

    @ApiOperation(value = "删除活动类型2")
    @RequestMapping(value = "type2/{id}", method = RequestMethod.DELETE)
    public Result<Boolean> removeType2Activity(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(activityManageService.removeType2Activity(id));
    }

    @ApiOperation(value = "活动上线")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "publish/up/{id}", method = RequestMethod.POST)
    public Result<Boolean> online(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(activityManageService.online(id));
    }

    @ApiOperation(value = "活动下线")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "publish/down/{id}", method = RequestMethod.POST)
    public Result<Boolean> offline(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(activityManageService.offline(id));
    }

    @ApiOperation(value = "查询上线活动")
    @RequestMapping(value = "online", method = RequestMethod.GET)
    public Result<List<ActivityBackVO>> queryOnline() {
        return new Result<>(activityManageService.queryOnline());
    }

    @ApiOperation(value = "增加优先级")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "priorityLevel/up/{id}", method = RequestMethod.POST)
    public Result<Boolean> priorityLevelUp(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(activityManageService.adjustPriority(id, "up"));
    }

    @ApiOperation(value = "减小优先级")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "priorityLevel/down/{id}", method = RequestMethod.POST)
    public Result<Boolean> priorityLevelDown(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(activityManageService.adjustPriority(id, "down"));
    }
}
