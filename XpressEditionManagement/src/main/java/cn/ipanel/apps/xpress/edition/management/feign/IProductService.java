package cn.ipanel.apps.xpress.edition.management.feign;

import cn.ipanel.apps.xpress.edition.management.controller.request.ProductReq;
import cn.ipanel.apps.xpress.edition.management.controller.response.ProductBackVO;
import feign.hystrix.FallbackFactory;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/12 上午11:09
 * Modified By:
 * Description:
 */
@Component
@FeignClient(name = "MarketingCampaignService", fallbackFactory = IProductService.ProductServiceImpl.class)
public interface IProductService {

    @RequestMapping(value = "/manage/product", method = RequestMethod.GET)
    FeignResult<List<ProductBackVO>> queryProduct();

    @RequestMapping(value = "/manage/product", method = RequestMethod.POST)
    FeignResult<Boolean> addProduct(@RequestBody ProductReq goodsReq);

    @RequestMapping(value = "/manage/product/{id}", method = RequestMethod.PUT)
    FeignResult<Boolean> modifyProduct(@PathVariable(value = "id") Integer id, @RequestBody ProductReq req);

    @RequestMapping(value = "/manage/product/{id}", method = RequestMethod.DELETE)
    FeignResult<Boolean> removeProduct(@PathVariable(value = "id") Integer id);

    @Component
    static class ProductServiceImpl implements FallbackFactory<IProductService> {

        @Override
        public IProductService create(Throwable cause) {
            return new IProductService() {
                @Override
                public FeignResult<List<ProductBackVO>> queryProduct() {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> addProduct(ProductReq goodsReq) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> modifyProduct(Integer id, ProductReq req) {
                    return new FeignResult<>(cause);
                }

                @Override
                public FeignResult<Boolean> removeProduct(Integer id) {
                    return new FeignResult<>(cause);
                }
            };
        }
    }
}
