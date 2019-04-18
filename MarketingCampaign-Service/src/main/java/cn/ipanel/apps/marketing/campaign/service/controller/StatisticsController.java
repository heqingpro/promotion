package cn.ipanel.apps.marketing.campaign.service.controller;

import cn.ipanel.apps.marketing.campaign.service.controller.resp.Result;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.ActivityStatisticsVO;
import cn.ipanel.apps.marketing.campaign.service.global.Globals;
import cn.ipanel.apps.marketing.campaign.service.service.IStatisticsService;
import cn.ipanel.apps.marketing.campaign.service.service.impl.StatisticsServiceImpl;
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
 * Create: 2018/9/19 下午2:56
 * Modified By:
 * Description:
 */
@Api(tags = Globals.API_BACK)
@RestController
@RequestMapping(value = "statistics")
public class StatisticsController {

    private IStatisticsService statisticsService;

    @Autowired
    public StatisticsController(IStatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @ApiOperation(value = "查询统计数据")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "activityId", value = "活动id", required = true, dataTypeClass = Integer.class, paramType = "query"),
            @ApiImplicitParam(name = "startDay", value = "开始日期", required = true, dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "endDay", value = "结束日期", required = true, dataTypeClass = String.class, paramType = "query")
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result<ActivityStatisticsVO> queryStatistics(@RequestParam("activityId") Integer activityId,
                                                        @RequestParam("startDay") String startDay,
                                                        @RequestParam("endDay") String endDay) throws Exception {
        return new Result<>(statisticsService.queryStatisticsInfo(activityId, startDay, endDay));
    }
}
