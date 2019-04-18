package cn.ipanel.apps.marketing.campaign.service.controller;

import cn.ipanel.apps.marketing.campaign.service.controller.req.GoodsReq;
import cn.ipanel.apps.marketing.campaign.service.controller.req.ProductReq;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.Result;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.ProductBackVO;
import cn.ipanel.apps.marketing.campaign.service.global.Globals;
import cn.ipanel.apps.marketing.campaign.service.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/12 下午12:07
 * Modified By:
 * Description:
 */
@Api(tags = Globals.API_BACK)
@RestController
@RequestMapping(value = "/manage/product")
public class ProductManageController {

    private IProductService productService;

    @Autowired
    public ProductManageController(IProductService productService) {
        this.productService = productService;
    }

    @ApiOperation(value = "查询产品列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result<List<ProductBackVO>> queryProduct() {
        return new Result<>(productService.queryProduct());
    }

    @ApiOperation(value = "添加商品")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Result<Boolean> addGoods(@RequestBody ProductReq goodsReq) throws Exception {
        return new Result<>(productService.addProduct(goodsReq));
    }

    @ApiOperation(value = "修改商品")
    @ApiImplicitParam(name = "id", value = "商品id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Result<Boolean> modifyGoods(@PathVariable(value = "id") Integer id, @RequestBody ProductReq req) throws Exception {
        return new Result<>(productService.modifyProduct(id, req));
    }

    @ApiOperation(value = "删除商品")
    @ApiImplicitParam(name = "id", value = "商品id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Result<Boolean> removeGoods(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(productService.removeProduct(id));
    }
}
