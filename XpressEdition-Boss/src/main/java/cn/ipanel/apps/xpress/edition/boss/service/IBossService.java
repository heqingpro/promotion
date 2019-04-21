package cn.ipanel.apps.xpress.edition.boss.service;

import cn.ipanel.apps.xpress.edition.boss.controller.req.BuyOfferReq;
import cn.ipanel.apps.xpress.edition.boss.controller.req.CheckGoodsOrderReq;
import cn.ipanel.apps.xpress.edition.boss.controller.req.CheckIsMarketingReq;
import cn.ipanel.apps.xpress.edition.boss.controller.req.CheckProductOrderReq;
import cn.ipanel.apps.xpress.edition.boss.controller.resp.CustomerVO;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/4 下午2:24
 * Modified By:
 * Description:
 */
public interface IBossService{

    /**
     * 查询用户信息
     * @param userId ca卡或者机顶盒号
     * @return info
     * @throws Exception e
     */
    CustomerVO getCustomerInfo(String userId) throws Exception;

    Boolean order(String ca, String productId, String offerId) throws Exception;

    Boolean baseOrder(String ca, String offerId, String productId) throws Exception;

    Boolean checkOrder(String ca, String productId) throws Exception;

    Boolean checkGoodsOrder(CheckGoodsOrderReq req) throws Exception;

    Boolean checkProductOrder(CheckProductOrderReq req) throws Exception;

    Boolean checkIsMarketing(CheckIsMarketingReq req) throws Exception;

    Boolean buyOffer(BuyOfferReq req) throws Exception;
}
