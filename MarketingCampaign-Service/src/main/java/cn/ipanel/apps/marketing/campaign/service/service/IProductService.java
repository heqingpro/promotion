package cn.ipanel.apps.marketing.campaign.service.service;

import cn.ipanel.apps.marketing.campaign.service.controller.req.ProductReq;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.ProductBackVO;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/23 下午3:01
 * Modified By:
 * Description:
 */
public interface IProductService {
    List<ProductBackVO> queryProduct();

    Boolean addProduct(ProductReq req) throws Exception;

    Boolean modifyProduct(Integer id, ProductReq req) throws Exception;

    Boolean removeProduct(Integer id) throws Exception;
}
