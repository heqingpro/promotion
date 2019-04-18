package cn.ipanel.apps.xpress.edition.management.feign;

import cn.ipanel.apps.xpress.edition.management.controller.request.MouldReq;
import cn.ipanel.apps.xpress.edition.management.controller.response.MouldBackVO;
import cn.ipanel.apps.xpress.edition.management.controller.response.MouldStatisticsVO;
import cn.ipanel.apps.xpress.edition.management.controller.response.UserMessageVO;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/8 下午2:04
 * Modified By:
 * Description:
 */
@Component
@FeignClient(name = "InteractiveWindowService", fallbackFactory = IMouldManageService.WindowsServiceFallback.class)
public interface IMouldManageService {

    @RequestMapping(value = "manage/mould", method = RequestMethod.POST)
    FeignResult<Boolean> addMould(@RequestBody MouldReq req);

    @RequestMapping(value = "manage/mould/{id}", method = RequestMethod.GET)
    FeignResult<MouldBackVO> queryMould(@PathVariable(value = "id") Integer id);

    @RequestMapping(value = "manage/mould/{id}", method = RequestMethod.PUT)
    FeignResult<Boolean> modifyMould(@PathVariable(value = "id") Integer id, @RequestBody MouldReq req);

    @RequestMapping(value = "manage/mould/{id}", method = RequestMethod.DELETE)
    FeignResult<Boolean> removeMould(@PathVariable(value = "id") Integer id);

    @RequestMapping(value = "manage/mould", method = RequestMethod.GET)
    FeignResult<List<MouldBackVO>> queryMould();

    @RequestMapping(value = "manage/mould/priorityLevel", method = RequestMethod.GET)
    FeignResult<List<MouldBackVO>> queryMouldByPriorityLevel();

    @RequestMapping(value = "/manage/mould/priorityLevel/up/{id}", method = RequestMethod.POST)
    FeignResult<Boolean> priorityLevelUp(@PathVariable(value = "id") Integer id);

    @RequestMapping(value = "/manage/mould/priorityLevel/down/{id}", method = RequestMethod.POST)
    FeignResult<Boolean> priorityLevelDown(@PathVariable(value = "id") Integer id);

    @RequestMapping(value = "statistics", method = RequestMethod.GET)
    FeignResult<MouldStatisticsVO> queryStatistics(@RequestParam("mouldId") Integer mouldId, @RequestParam("startDay") String startDay, @RequestParam("endDay") String endDay);

    @RequestMapping(value = "statistics/user/message", method = RequestMethod.GET)
    FeignResult<List<UserMessageVO>> queryUserMessage(@RequestParam("user") String user);

    @Component
    class WindowsServiceFallback implements FallbackFactory<IMouldManageService> {

        @Override
        public IMouldManageService create(Throwable cause) {
            return new IMouldManageService() {
                @Override
                public FeignResult<Boolean> addMould(MouldReq req) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<MouldBackVO> queryMould(Integer id) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> modifyMould(Integer id, MouldReq req) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> removeMould(Integer id) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<List<MouldBackVO>> queryMould() {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<List<MouldBackVO>> queryMouldByPriorityLevel() {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> priorityLevelUp(Integer id) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> priorityLevelDown(Integer id) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<MouldStatisticsVO> queryStatistics(Integer mouldId, String startDay, String endDay) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<List<UserMessageVO>> queryUserMessage(String user) {
                    return new FeignResult<>(cause);
                }
            };
        }
    }
}
