package cn.ipanel.apps.marketing.campaign.service.service.feign;

import cn.ipanel.apps.marketing.campaign.service.dto.CustomerVO;
import cn.ipanel.apps.marketing.campaign.service.service.feign.bean.BuyOfferReq;
import cn.ipanel.apps.marketing.campaign.service.service.feign.bean.CheckGoodsOrderReq;
import cn.ipanel.apps.marketing.campaign.service.service.feign.bean.CheckIsMarketingReq;
import cn.ipanel.apps.marketing.campaign.service.service.feign.bean.CheckProductOrderReq;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "boss/check/goods", method = RequestMethod.POST)
    FeignResult<Boolean> checkGoodsOrder(@RequestBody CheckGoodsOrderReq req);

    @RequestMapping(value = "boss/check/product", method = RequestMethod.POST)
    FeignResult<Boolean> checkProductOrder(@RequestBody CheckProductOrderReq req);

    @RequestMapping(value = "boss/check/marketing", method = RequestMethod.POST)
    FeignResult<Boolean> checkIsMarketing(@RequestBody CheckIsMarketingReq req) throws Exception;

    @RequestMapping(value = "boss/buyOffer", method = RequestMethod.POST)
    FeignResult<Boolean> buyOffer(@RequestBody BuyOfferReq req) throws Exception;

    @Component
    class BossServiceFallbackFactory implements FallbackFactory<IBossService> {

        @Override
        public IBossService create(Throwable cause) {
            return new IBossService() {
                @Override
                public FeignResult<CustomerVO> getCustomerInfo(String userId) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> checkGoodsOrder(CheckGoodsOrderReq req) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> checkProductOrder(CheckProductOrderReq req) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> checkIsMarketing(CheckIsMarketingReq req) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> buyOffer(BuyOfferReq req) {
                    return new FeignResult<>(cause);
                }
            };
        }
    }
}
