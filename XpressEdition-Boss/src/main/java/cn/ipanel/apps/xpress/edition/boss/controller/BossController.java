package cn.ipanel.apps.xpress.edition.boss.controller;

import cn.ipanel.apps.xpress.edition.boss.controller.req.BuyOfferReq;
import cn.ipanel.apps.xpress.edition.boss.controller.req.CheckGoodsOrderReq;
import cn.ipanel.apps.xpress.edition.boss.controller.req.CheckIsMarketingReq;
import cn.ipanel.apps.xpress.edition.boss.controller.req.CheckProductOrderReq;
import cn.ipanel.apps.xpress.edition.boss.controller.resp.CustomerVO;
import cn.ipanel.apps.xpress.edition.boss.controller.resp.Result;
import cn.ipanel.apps.xpress.edition.boss.service.IBossService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/5 下午5:42
 * Modified By:
 * Description:
 */
@Api(tags = "微服务接口")
@RestController
@RequestMapping(value = "boss")
public class BossController {

    private IBossService bossService;

    @Autowired
    public BossController(IBossService bossService) {
        this.bossService = bossService;
    }

    @ApiOperation(value = "查询用户信息")
    @ApiImplicitParam(name = "userId", value = "用户CA卡或机顶盒号", required = true, dataTypeClass = String.class, paramType = "path")
    @RequestMapping(value = "customer/{userId}", method = RequestMethod.GET)
    public Result<CustomerVO> queryCustomerInfo(@PathVariable(value = "userId") String userId) throws Exception {
        return new Result<>(bossService.getCustomerInfo(userId));
    }

    @ApiOperation(value = "查询商品是否订购")
    @ApiImplicitParam(name = "req", value = "req", required = true, dataType = "CheckGoodsOrderReq", paramType = "body")
    @RequestMapping(value = "check/goods", method = RequestMethod.POST)
    public Result<Boolean> checkGoodsOrder(@RequestBody CheckGoodsOrderReq req) throws Exception {
        return new Result<>(bossService.checkGoodsOrder(req));
    }

    @ApiOperation(value = "查询产品是否订购")
    @ApiImplicitParam(name = "req", value = "req", required = true, dataType = "CheckProductOrderReq", paramType = "body")
    @RequestMapping(value = "check/product", method = RequestMethod.POST)
    public Result<Boolean> checkProductOrder(@RequestBody CheckProductOrderReq req) throws Exception {
        return new Result<>(bossService.checkProductOrder(req));
    }

    @ApiOperation(value = "查询用户是否符合续订条件")
    @ApiImplicitParam(name = "req", value = "req", required = true, dataType = "CheckIsMarketingReq", paramType = "body")
    @RequestMapping(value = "check/marketing", method = RequestMethod.POST)
    public Result<Boolean> checkIsMarketing(@RequestBody CheckIsMarketingReq req) throws Exception {
        return new Result<>(bossService.checkIsMarketing(req));
    }

    @ApiOperation(value = "商品订购")
    @ApiImplicitParam(name = "req", value = "req", required = true, dataType = "BuyOfferReq", paramType = "body")
    @RequestMapping(value = "buyOffer", method = RequestMethod.POST)
    public Result<Boolean> buyOffer(@RequestBody BuyOfferReq req) throws Exception {
        return new Result<>(bossService.buyOffer(req));
    }
}
