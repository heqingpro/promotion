package cn.ipanel.apps.marketing.campaign.service.controller;

import cn.ipanel.apps.marketing.campaign.service.controller.resp.tv.ActivityTVVO;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.Result;
import cn.ipanel.apps.marketing.campaign.service.global.Globals;
import cn.ipanel.apps.marketing.campaign.service.service.IActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/14 下午4:58
 * Modified By:
 * Description:
 */
@Api(tags = Globals.API_TV)
@RestController
@RequestMapping(value = "activity")
public class ActivityController {

    private IActivityService activityService;

    @Autowired
    public ActivityController(IActivityService activityService) {
        this.activityService = activityService;
    }

    @ApiOperation(value = "查询有效活动")
    @ApiImplicitParam(name = "user", value = "用户CA卡", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result<ActivityTVVO> queryActivity(@RequestParam(value = "user") String userId) throws Exception {
        return new Result<>(activityService.queryActivity(userId));
    }

    @ApiOperation(value = "弹窗响应", notes = "data字段如果是空字符串表示操作成功，如果不为空字符串表示操作失败")
    @RequestMapping(value = "response", method = RequestMethod.GET)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "serialNumber", value = "弹窗序列号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "user", value = "用户CA卡", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "activityId", value = "活动id", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "popTime", value = "弹窗生成时间", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "response", value = "弹窗响应动作", required = true, dataType = "String", paramType = "query")
    })
    public Result<Boolean> response(@RequestParam(value = "serialNumber") String serialNumber,
                                   @RequestParam(value = "user") String userId,
                                   @RequestParam(value = "activityId") Integer activityId,
                                   @RequestParam(value = "popTime") Long popTime,
                                   @RequestParam(value = "response") String response) throws Exception {
        return new Result<>(activityService.activityResponse(serialNumber, userId, activityId, popTime, response));
    }
}
