package cn.ipanel.apps.interactive.window.feign;

import cn.ipanel.apps.interactive.window.dto.CustomerVO;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/4 下午2:24
 * Modified By:
 * Description:
 */
@Component
@FeignClient(name = "XpressEditionBossService", fallbackFactory = IBossService.BossServiceFallbackFactory.class)
public interface IBossService {

    @RequestMapping(value = "boss/customer/{userId}", method = RequestMethod.GET)
    FeignResult<CustomerVO> getCustomerInfo(@PathVariable(value = "userId") String userId);

    @Component
    class BossServiceFallbackFactory implements FallbackFactory<IBossService> {

        @Override
        public IBossService create(Throwable cause) {
            return userId -> new FeignResult<>(cause);
        }
    }
}
