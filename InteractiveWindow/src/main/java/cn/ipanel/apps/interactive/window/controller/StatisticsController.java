package cn.ipanel.apps.interactive.window.controller;

import cn.ipanel.apps.interactive.window.controller.resp.Result;
import cn.ipanel.apps.interactive.window.controller.resp.back.MouldStatisticsVO;
import cn.ipanel.apps.interactive.window.controller.resp.back.UserMessageVO;
import cn.ipanel.apps.interactive.window.global.Globals;
import cn.ipanel.apps.interactive.window.service.IStatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/18 上午11:47
 * Modified By:
 * Description:
 */
@Api(tags = Globals.API_BACK)
@RequestMapping(value = "statistics")
@RestController
public class StatisticsController {


    private IStatisticsService statisticsService;

    @Autowired
    public StatisticsController(IStatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @ApiOperation(value = "查询统计数据")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "mouldId", value = "模板id", required = true, dataTypeClass = Integer.class, paramType = "query"),
            @ApiImplicitParam(name = "startDay", value = "开始日期", required = false, dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "endDay", value = "结束日期", required = false, dataTypeClass = String.class, paramType = "query")
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result<MouldStatisticsVO> queryStatistics(@RequestParam("mouldId") Integer mouldId,
                                                     @RequestParam(value = "startDay", required = false) String startDay,
                                                     @RequestParam(value = "endDay", required = false) String endDay) throws Exception {
        return new Result<>(statisticsService.queryStatisticsInfo(mouldId, startDay, endDay));
    }

    @ApiOperation(value = "查询用户弹窗记录")
    @ApiImplicitParam(name = "user", value = "用户认证标识", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = "user/message", method = RequestMethod.GET)
    public Result<List<UserMessageVO>> queryUserRecord(@RequestParam(value = "user") String user) {
        return new Result<>(statisticsService.queryUserMessage(user));
    }
}
