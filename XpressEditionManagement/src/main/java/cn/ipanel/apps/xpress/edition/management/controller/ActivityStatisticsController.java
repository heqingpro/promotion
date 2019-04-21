package cn.ipanel.apps.xpress.edition.management.controller;

import cn.ipanel.apps.xpress.edition.management.controller.response.ActivityStatisticsVO;
import cn.ipanel.apps.xpress.edition.management.controller.response.Result;
import cn.ipanel.apps.xpress.edition.management.feign.IActivityManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/19 下午5:30
 * Modified By:
 * Description:
 */
@Slf4j
@Controller
@RequestMapping(value = "activity/statistics")
public class ActivityStatisticsController {

    private IActivityManageService activityManageService;

    @Autowired
    public ActivityStatisticsController(IActivityManageService activityManageService) {
        this.activityManageService = activityManageService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String activityStatistics(ModelMap map) {
        try {
            map.put("activityList", activityManageService.queryActivity().getData());
        } catch (Exception e) {
            log.error("{}", e.getMessage(), e);
        }
        return "activity_statistics";
    }

    @RequestMapping(value = "query", method = RequestMethod.GET)
    @ResponseBody
    public Result<ActivityStatisticsVO> queryStatistics(@RequestParam("activityId") Integer activityId,
                                                        @RequestParam("startDay") String startDay,
                                                        @RequestParam("endDay") String endDay) {
        return new Result<>(activityManageService.queryStatistics(activityId, startDay, endDay));
    }
}
