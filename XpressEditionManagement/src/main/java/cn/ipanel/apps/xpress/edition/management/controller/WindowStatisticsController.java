package cn.ipanel.apps.xpress.edition.management.controller;

import cn.ipanel.apps.xpress.edition.management.controller.response.DataTablesVO;
import cn.ipanel.apps.xpress.edition.management.controller.response.MouldStatisticsVO;
import cn.ipanel.apps.xpress.edition.management.controller.response.Result;
import cn.ipanel.apps.xpress.edition.management.controller.response.UserMessageVO;
import cn.ipanel.apps.xpress.edition.management.feign.IMouldManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
@RequestMapping(value = "window/statistics")
public class WindowStatisticsController {

    private IMouldManageService mouldManageService;

    @Autowired
    public WindowStatisticsController(IMouldManageService mouldManageService) {
        this.mouldManageService = mouldManageService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String activityStatistics(ModelMap map) {
        try {
            map.put("mouldList", mouldManageService.queryMould().getData());
        } catch (Exception e) {
            log.error("{}", e.getMessage(), e);
        }
        return "window_statistics";
    }

    @RequestMapping(value = "query", method = RequestMethod.GET)
    @ResponseBody
    public Result<MouldStatisticsVO> queryStatistics(@RequestParam("mouldId") Integer activityId,
                                                     @RequestParam(value = "startDay", required = false) String startDay,
                                                     @RequestParam(value = "endDay", required = false) String endDay) {
        return new Result<>(mouldManageService.queryStatistics(activityId, startDay, endDay));
    }

    @RequestMapping(value = "user/message", method = RequestMethod.GET)
    @ResponseBody
    public DataTablesVO<UserMessageVO> queryOnline(HttpServletRequest httpServletRequest, @RequestParam("user") String user) {
        String draw = httpServletRequest.getParameter("draw");
        return new DataTablesVO<>(Integer.parseInt(draw), mouldManageService.queryUserMessage(user).getData());
    }
}
