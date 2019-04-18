package cn.ipanel.apps.xpress.edition.management.feign;

import cn.ipanel.apps.xpress.edition.management.controller.request.activity.Type1Req;
import cn.ipanel.apps.xpress.edition.management.controller.request.activity.Type2Req;
import cn.ipanel.apps.xpress.edition.management.controller.response.ActivityBackVO;
import cn.ipanel.apps.xpress.edition.management.controller.response.ActivityStatisticsVO;
import cn.ipanel.apps.xpress.edition.management.controller.response.Type1ActivityBackVO;
import cn.ipanel.apps.xpress.edition.management.controller.response.Type2ActivityBackVO;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzhihao
 * Create: 2018-05-08 上午9:54
 * Modified By:
 * Description:
 */
@Component
@FeignClient(name = "MarketingCampaignService", fallbackFactory = IActivityManageService.ActivityManageServiceImpl.class)
public interface IActivityManageService {

    @RequestMapping(value = "/manage/activity", method = RequestMethod.GET)
    FeignResult<List<ActivityBackVO>> queryActivity();

    @RequestMapping(value = "/manage/activity/type1", method = RequestMethod.POST)
    FeignResult<Boolean> addType1Activity(Type1Req req) throws Exception;

    @RequestMapping(value = "/manage/activity/type1/{id}", method = RequestMethod.GET)
    FeignResult<Type1ActivityBackVO> queryType1Activity(@PathVariable(value = "id") Integer id);

    @RequestMapping(value = "/manage/activity/type1/{id}", method = RequestMethod.PUT)
    FeignResult<Boolean> modifyType1Activity(@PathVariable(value = "id") Integer id, Type1Req req);

    @RequestMapping(value = "/manage/activity/type1/{id}", method = RequestMethod.DELETE)
    FeignResult<Boolean> removeType1Activity(@PathVariable(value = "id") Integer id);

    @RequestMapping(value = "/manage/activity/type2", method = RequestMethod.POST)
    FeignResult<Boolean> addType2Activity(Type2Req req);

    @RequestMapping(value = "/manage/activity/type2/{id}", method = RequestMethod.GET)
    FeignResult<Type2ActivityBackVO> queryType2Activity(@PathVariable(value = "id") Integer id);

    @RequestMapping(value = "/manage/activity/type2/{id}", method = RequestMethod.PUT)
    FeignResult<Boolean> modifyType2Activity(@PathVariable(value = "id") Integer id, Type2Req req);

    @RequestMapping(value = "/manage/activity/type2/{id}", method = RequestMethod.DELETE)
    FeignResult<Boolean> removeType2Activity(@PathVariable(value = "id") Integer id);

    @RequestMapping(value = "/manage/activity/publish/up/{id}", method = RequestMethod.POST)
    FeignResult<Boolean> online(@PathVariable(value = "id") Integer id);

    @RequestMapping(value = "/manage/activity/publish/down/{id}", method = RequestMethod.POST)
    FeignResult<Boolean> offline(@PathVariable(value = "id") Integer id);

    @RequestMapping(value = "/manage/activity/priorityLevel/up/{id}", method = RequestMethod.POST)
    FeignResult<Boolean> priorityLevelUp(@PathVariable(value = "id") Integer id);

    @RequestMapping(value = "/manage/activity/priorityLevel/down/{id}", method = RequestMethod.POST)
    FeignResult<Boolean> priorityLevelDown(@PathVariable(value = "id") Integer id);

    @RequestMapping(value = "/manage/activity/online", method = RequestMethod.GET)
    FeignResult<List<ActivityBackVO>> queryOnline();

    @RequestMapping(value = "statistics", method = RequestMethod.GET)
    FeignResult<ActivityStatisticsVO> queryStatistics(@RequestParam("activityId") Integer activityId, @RequestParam("startDay") String startDay, @RequestParam("endDay") String endDay);

    @Component
    class ActivityManageServiceImpl implements FallbackFactory<IActivityManageService> {

        @Override
        public IActivityManageService create(Throwable cause) {
            return new IActivityManageService() {
                @Override
                public FeignResult<List<ActivityBackVO>> queryActivity() {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Type1ActivityBackVO> queryType1Activity(Integer id) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> addType1Activity(Type1Req req) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> modifyType1Activity(Integer id, Type1Req req) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> removeType1Activity(Integer id) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Type2ActivityBackVO> queryType2Activity(Integer id) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> addType2Activity(Type2Req req) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> modifyType2Activity(Integer id, Type2Req req) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> removeType2Activity(Integer id) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> online(Integer id) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> offline(Integer id) {
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
                public FeignResult<List<ActivityBackVO>> queryOnline() {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<ActivityStatisticsVO> queryStatistics(Integer activityId, String startDay, String endDay) {
                    return new FeignResult<>(cause);
                }
            };
        }
    }
}
