package cn.ipanel.apps.xpress.edition.management.feign;

import cn.ipanel.apps.xpress.edition.management.controller.response.AreaVO;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/13 下午2:33
 * Modified By:
 * Description:
 */
@Component
@FeignClient(name = "MarketingCampaignService", fallbackFactory = IActivityAreaService.AreaServiceFallback.class)
public interface IActivityAreaService {

    @RequestMapping(value = "area", method = RequestMethod.GET)
    FeignResult<List<AreaVO>> queryArea();

    @Component
    class AreaServiceFallback implements FallbackFactory<IActivityAreaService> {

        @Override
        public IActivityAreaService create(Throwable cause) {
            return () -> new FeignResult<>(cause);
        }
    }
}
