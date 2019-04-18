package cn.ipanel.apps.xpress.edition.management.feign;

import cn.ipanel.apps.xpress.edition.management.controller.response.UserFilterVO;
import feign.hystrix.FallbackFactory;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
 * @author luzh
 * Create: 2018/9/20 上午11:00
 * Modified By:
 * Description:
 */
@Component
@FeignClient(name = "MarketingCampaignService")
public interface IUserFilterService {

    @RequestMapping(value = "user/filter", method = RequestMethod.POST)
    FeignResult<Boolean> addUser(@RequestParam(value = "user") String user);

    @RequestMapping(value = "user/filter/{id}", method = RequestMethod.PUT)
    FeignResult<Boolean> modifyUser(@PathVariable(value = "id") Integer id, @RequestParam(value = "user") String user);

    @RequestMapping(value = "user/filter/{id}", method = RequestMethod.DELETE)
    FeignResult<Boolean> removeUser(@PathVariable(value = "id") Integer id);

    @RequestMapping(value = "user/filter", method = RequestMethod.GET)
    FeignResult<List<UserFilterVO>> queryFilterList();

    @Component
    class UserFilterServiceFallback implements FallbackFactory<IUserFilterService> {

        @Override
        public IUserFilterService create(Throwable cause) {
            return new IUserFilterService() {
                @Override
                public FeignResult<Boolean> addUser(String user) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> modifyUser(Integer id, String user) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> removeUser(Integer id) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<List<UserFilterVO>> queryFilterList() {
                    return new FeignResult<>(cause);
                }
            };
        }
    }
}
