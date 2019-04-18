package cn.ipanel.apps.xpress.edition.management.feign;

import cn.ipanel.apps.xpress.edition.management.controller.request.GoodsReq;
import cn.ipanel.apps.xpress.edition.management.controller.response.GoodsBackVO;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/12 上午11:06
 * Modified By:
 * Description:
 */
@Component
@FeignClient(name = "MarketingCampaignService", fallbackFactory = IGoodsService.GoodsServiceImpl.class)
public interface IGoodsService {

    @RequestMapping(value = "/manage/goods", method = RequestMethod.POST)
    FeignResult<Boolean> addGoods(GoodsReq req) throws Exception;

    @RequestMapping(value = "/manage/goods/{id}", method = RequestMethod.PUT)
    FeignResult<Boolean> modifyGoods(@PathVariable(value = "id") Integer id, GoodsReq req) throws Exception;

    @RequestMapping(value = "/manage/goods/{id}", method = RequestMethod.DELETE)
    FeignResult<Boolean> removeGoods(@PathVariable(value = "id") Integer id) throws Exception;

    @RequestMapping(value = "/manage/goods", method = RequestMethod.GET)
    FeignResult<List<GoodsBackVO>> queryGoods();

    @Component
    static class GoodsServiceImpl implements FallbackFactory<IGoodsService> {

        @Override
        public IGoodsService create(Throwable cause) {
            return new IGoodsService() {
                @Override
                public FeignResult<Boolean> addGoods(GoodsReq req) throws Exception {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> modifyGoods(Integer id, GoodsReq req) throws Exception {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> removeGoods(Integer id) throws Exception {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<List<GoodsBackVO>> queryGoods() {
                    return new FeignResult<>(cause);
                }
            };
        }
    }
}
