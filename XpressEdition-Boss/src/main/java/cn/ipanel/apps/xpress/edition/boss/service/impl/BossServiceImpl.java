package cn.ipanel.apps.xpress.edition.boss.service.impl;

import cn.ipanel.apps.xpress.edition.boss.controller.req.BuyOfferReq;
import cn.ipanel.apps.xpress.edition.boss.controller.req.CheckGoodsOrderReq;
import cn.ipanel.apps.xpress.edition.boss.controller.req.CheckIsMarketingReq;
import cn.ipanel.apps.xpress.edition.boss.controller.req.CheckProductOrderReq;
import cn.ipanel.apps.xpress.edition.boss.controller.resp.CustomerVO;
import cn.ipanel.apps.xpress.edition.boss.global.Globals;
import cn.ipanel.apps.xpress.edition.boss.global.MyCommonException;
import cn.ipanel.apps.xpress.edition.boss.service.IBossService;
import com.dvte.boss.ws.callcenter.OfferOrderModel;
import com.dvte.boss.ws.callcenter.PurchaseReturn;
import com.google.gson.Gson;
import com.xmbtn.boss.qfee.server.CustomerInfoVO;
import com.xmbtn.boss.qfee.server.FeeQuerynewdaoLocator;
import com.xmbtn.boss.qfee.server.HsOfferVO;
import com.xmbtn.boss.qfee.server.IFeeQueryNewDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/4 下午2:24
 * Modified By:
 * Description:
 */
@Slf4j
@Service
@RefreshScope
public class BossServiceImpl implements IBossService {

    private static final String ORDER_TYPE_NOT_ORDER = "3";
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static Gson gson = new Gson();
    private static final String DEFAULT_OPERATOR_CODE = "BBBBBB";

    private static final FeeQuerynewdaoLocator locator = new FeeQuerynewdaoLocator();
    private IFeeQueryNewDAO feeQueryNewDAO = null;

    @Value("${boss.url}")
    private String bossUrl;
    private String localBossUrl;

    private IFeeQueryNewDAO getFeeQueryNewDAO(String url) throws Exception {
        if (Globals.isEmpty(url)) {
            throw new MyCommonException("-1", "boss接口地址错误");
        }
        if (null == this.feeQueryNewDAO || !url.equals(this.localBossUrl)) {
            this.localBossUrl = url;
            log.info("bossUrl: {}", this.localBossUrl);
            this.feeQueryNewDAO = locator.getFeeQueryNewDAOImplPort(new URL(this.localBossUrl));
        }
        return this.feeQueryNewDAO;
    }

    @Override
    public CustomerVO getCustomerInfo(String ca) throws Exception {
        log.info("by luzh: 查询用户信息: {}.", ca);
        CustomerInfoVO customerInfo = getFeeQueryNewDAO(bossUrl).queryCustomerInfoByStbid(ca);
        if (null == customerInfo) {
            throw new MyCommonException("101", "用户信息不存在");
        }
        CustomerVO customerVO = new CustomerVO(
                customerInfo.getCompany_name(),
                customerInfo.getCust_no(),
                customerInfo.getStbcode(),
                customerInfo.getSubscriberid()
        );
        log.info("by luzh: 用户信息: {}.", gson.toJson(customerInfo));
        return customerVO;
    }

    @Override
    public Boolean order(String ca, String productId, String offerId) throws Exception {
        log.info("by luzh: VIP、回看订购-用户 {} 订购 {} .", ca, productId);
        CustomerVO customerInfo = getCustomerInfo(ca);
        HsOfferVO offerVO = checkProduct(customerInfo, productId);
        return orderBaseBuyOffer(offerVO, customerInfo, offerId);
    }

    private HsOfferVO checkProduct(CustomerVO customerInfo, String productId) throws Exception {
        log.info("by luzh: 查询产品是否订购请求参数: customerNo:{}、stbCode:{}、prodId:{}、subscriberId:{}、endTime:{}、hdFlag:{}.", customerInfo.getCustomerNo(), customerInfo.getStbCode(), productId, customerInfo.getSubscriberId(), "空", "0");
        HsOfferVO offerVO = getFeeQueryNewDAO(bossUrl).checkOrderProd(customerInfo.getCustomerNo(), customerInfo.getStbCode(), productId, customerInfo.getSubscriberId(), "", "0");
        log.info("by luzh: 查询产品是否订购返回结果: {}.", gson.toJson(offerVO));
        return offerVO;
    }

    private Boolean orderBaseBuyOffer(HsOfferVO offerVO, CustomerVO customerInfo, String offerId) throws Exception {
        switch (offerVO.getOrder_type()) {
            case ORDER_TYPE_NOT_ORDER:
                log.info("用户未订购，开始订购.");
                OfferOrderModel offerOrderModel = new OfferOrderModel(offerVO.getEndtime(), 1, offerId, dateTimeFormatter.format(LocalDate.now()));
                log.info("bu luzh: 订购请求参数: OfferOrderModel: {}、subscriberId: {}、customerNo: {}、operatorCode: {}、isPay: {}、operateChannel: {}.",
                        gson.toJson(new OfferOrderModel[]{offerOrderModel}),
                        gson.toJson(new String[]{customerInfo.getSubscriberId()}),
                        customerInfo.getCustomerNo(),
                        DEFAULT_OPERATOR_CODE,
                        "01",
                        "0003"
                );
                PurchaseReturn purchaseReturn = getFeeQueryNewDAO(bossUrl).buyOffer(
                        new OfferOrderModel[]{offerOrderModel},
                        new String[]{customerInfo.getSubscriberId()},
                        customerInfo.getCustomerNo(),
                        DEFAULT_OPERATOR_CODE,
                        "01",
                        "0003"
                );
                log.info("by luzh: 订购结果: {}.", gson.toJson(purchaseReturn));
                return purchaseReturn.getReturnCode().equals("00");
            case "1":
            case "2":
                log.info("用户已订购, 返回code=666, message={}.", offerVO.getOrder_msg());
                throw new MyCommonException("666", offerVO.getOrder_msg());
            default:
                log.info("其他未知状态, order_type={}, 返回code=-1, message={}.", offerVO.getOrder_type(), offerVO.getOrder_msg());
                throw new MyCommonException("-1", offerVO.getOrder_msg());
        }
    }

    @Override
    public Boolean baseOrder(String ca, String offerId, String productId) throws Exception {
        log.info("by luzh: 随心版基础包订购-用户 {} 订购 {}, 产品Id {}.", ca, offerId, productId);
        CustomerVO customerInfo = getCustomerInfo(ca);
        HsOfferVO offerVO = checkProduct(customerInfo, productId);
        return orderBaseBuyOffer(offerVO, customerInfo, offerId);
    }

    @Override
    public Boolean checkOrder(String ca, String productId) throws Exception {
        log.info("by luzh: 查询用户 {} 是否订购 {}.", ca, productId);
        CustomerVO customerInfo = getCustomerInfo(ca);
        HsOfferVO offerVO = checkProduct(customerInfo, productId);
        return checkGoodsOrProductReturn(offerVO);
    }

    @Override
    public Boolean checkGoodsOrder(CheckGoodsOrderReq req) throws Exception {
        log.info("by luzh: 查询商品是否订购请求参数: customerNo: {}、stbCode: {}、goodsId: {}、subscriberId: {}.",
                req.getCustomerVO().getCustomerNo(),
                req.getCustomerVO().getStbCode(),
                req.getGoodsId(),
                req.getCustomerVO().getSubscriberId()
        );
        HsOfferVO offerVO = getFeeQueryNewDAO(bossUrl).checkHsOfferToCust(
                req.getCustomerVO().getCustomerNo(),
                req.getCustomerVO().getStbCode(),
                req.getGoodsId(),
                req.getCustomerVO().getSubscriberId()
        );
        log.info("by luzh: 查询商品是否订购返回结果: {}.", gson.toJson(offerVO));
        return checkGoodsOrProductReturn(offerVO);
    }

    private Boolean checkGoodsOrProductReturn(HsOfferVO offerVO) throws Exception {
        switch (offerVO.getOrder_type()) {
            case ORDER_TYPE_NOT_ORDER:
                log.info("用户未订购");
                return false;
            case "1":
            case "2":
                log.info("用户已订购");
                return true;
            default:
                log.info("其他未知状态, order_type={}, 返回code=-1, message={}.", offerVO.getOrder_type(), offerVO.getOrder_msg());
                throw new MyCommonException("-1", offerVO.getOrder_msg());
        }
    }

    @Override
    public Boolean checkProductOrder(CheckProductOrderReq req) throws Exception {
        log.info("by luzh: 查询产品是否订购请求参数: customerNo: {}、stbCode: {}、productId: {}、subscriberId: }、hdFlag: {}.",
                req.getCustomerVO().getCustomerNo(),
                req.getCustomerVO().getStbCode(),
                req.getProductId(),
                req.getCustomerVO().getSubscriberId(),
                req.getHdFlag()
        );
        HsOfferVO offerVO = getFeeQueryNewDAO(bossUrl).checkOrderProdToCust(
                req.getCustomerVO().getCustomerNo(),
                req.getCustomerVO().getStbCode(),
                req.getProductId(),
                req.getCustomerVO().getSubscriberId(),
                req.getHdFlag()
        );
        log.info("by luzh: 查询产品是否订购返回结果: {}.", gson.toJson(offerVO));
        return checkGoodsOrProductReturn(offerVO);
    }

    @Override
    public Boolean checkIsMarketing(CheckIsMarketingReq req) throws Exception {
        log.info("by luzh: 查询用户是否满足续订条件请求参数: customerNo: {}、subscriberId: {}、goodsId: {}.",
                req.getCustomerVO().getCustomerNo(),
                req.getCustomerVO().getSubscriberId(),
                req.getGoodsId()
        );
        String result = getFeeQueryNewDAO(bossUrl).checkIsMarketing(
                req.getCustomerVO().getCustomerNo(),
                req.getCustomerVO().getSubscriberId(),
                req.getGoodsId()
        );
        log.info("by luzh: 查询用户是否满足续订条件返回结果: {}.", result);
        // 1不符合，0符合
        return !Globals.isEmpty(result) && ("0".equals(result));
    }

    @Override
    public Boolean buyOffer(BuyOfferReq req) throws Exception {
        log.info("by luzh: 用户 {} 订购 {}.", req.getCustomerInfo().getStbCode(), req.getOfferId());
        OfferOrderModel offerOrderModel = new OfferOrderModel(req.getEndTime(), 1, req.getOfferId(), req.getStartTime());
        log.info("bu luzh: 订购请求参数: OfferOrderModel: {}、subscriberId: {}、customerNo: {}、operatorCode: {}、isPay: {}、operateChannel: {}.",
                gson.toJson(new OfferOrderModel[]{offerOrderModel}),
                gson.toJson(new String[]{req.getCustomerInfo().getSubscriberId()}),
                req.getCustomerInfo().getCustomerNo(),
                req.getOperatorCode(),
                "01",
                "0003"
        );
        PurchaseReturn purchaseReturn = getFeeQueryNewDAO(bossUrl).buyOffer(
                new OfferOrderModel[]{offerOrderModel},
                new String[]{req.getCustomerInfo().getSubscriberId()},
                req.getCustomerInfo().getCustomerNo(),
                req.getOperatorCode(),
                "01",
                "0003"
        );
        log.info("by luzh: 订购结果: {}.", gson.toJson(purchaseReturn));
        return purchaseReturn.getReturnCode().equals("00");
    }
}
