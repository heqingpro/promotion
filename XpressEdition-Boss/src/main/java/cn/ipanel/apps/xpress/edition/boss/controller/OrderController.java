package cn.ipanel.apps.xpress.edition.boss.controller;

import cn.ipanel.apps.xpress.edition.boss.controller.resp.Result;
import cn.ipanel.apps.xpress.edition.boss.service.IBossService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/30 上午11:33
 * Modified By:
 * Description:
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping(value = "order")
public class OrderController {

    private IBossService orderService;

    @Autowired
    public OrderController(IBossService orderService) {
        this.orderService = orderService;
    }

    @ApiOperation(value = "vip、回看订购接口")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "user", value = "用户CA卡或机顶盒号", required = true, dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "productId", value = "产品id", required = true, dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "offerId", value = "商品offerId", required = true, dataTypeClass = String.class, paramType = "query")
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result<Boolean> vipOrder(@RequestParam(value = "user") String ca, @RequestParam(value = "productId") String productId, @RequestParam(value = "offerId") String offerId) throws Exception {
        return new Result<>(orderService.order(ca, productId, offerId));
    }

    @ApiOperation(value = "查询商品是否订购接口")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "user", value = "用户CA卡或机顶盒号", required = true, dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "productId", value = "产品id", required = true, dataTypeClass = String.class, paramType = "query")
    })
    @RequestMapping(value = "check", method = RequestMethod.GET)
    public Result<Boolean> checkOrder(@RequestParam(value = "user") String ca, @RequestParam(value = "productId") String productId) throws Exception {
        return new Result<>(orderService.checkOrder(ca, productId));
    }

    @ApiOperation(value = "随心版基础包订购")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "user", value = "用户CA卡或机顶盒号", required = true, dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "offerId", value = "商品offerId", required = true, dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "productId", value = "商品offerId", required = true, dataTypeClass = String.class, paramType = "query")
    })
    @RequestMapping(value = "base", method = RequestMethod.GET)
    public Result<Boolean> baseOrder(@RequestParam(value = "user") String ca, @RequestParam(value = "offerId") String offerId, @RequestParam(value = "productId") String productId) throws Exception {
        return new Result<>(orderService.baseOrder(ca, offerId, productId));
    }
}
