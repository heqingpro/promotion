package cn.ipanel.apps.xpress.edition.management.controller;

import cn.ipanel.apps.xpress.edition.management.annotation.LogHttpRequestParameter;
import cn.ipanel.apps.xpress.edition.management.annotation.LogHttpRequestResult;
import cn.ipanel.apps.xpress.edition.management.controller.request.ProductReq;
import cn.ipanel.apps.xpress.edition.management.controller.response.Result;
import cn.ipanel.apps.xpress.edition.management.feign.IProductService;
import cn.ipanel.apps.xpress.edition.management.global.Globals;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/20 下午3:35
 * Modified By:
 * Description:
 */
@Slf4j
@Api(tags = Globals.API_BACK)
@RequestMapping(value = "/activity/product")
@Controller
public class ProductManageController {

    private IProductService productService;

    @Autowired
    public ProductManageController(IProductService productService) {
        this.productService = productService;
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @ApiOperation(value = "添加商品")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> addProduct(@RequestBody ProductReq productReq)  {
        return new Result<>(productService.addProduct(productReq));
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @ApiOperation(value = "修改商品")
    @ApiImplicitParam(name = "id", value = "商品id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result<Boolean> modifyGoods(@PathVariable(value = "id") Integer id, @RequestBody ProductReq req) {
        return new Result<>(productService.modifyProduct(id, req));
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @ApiOperation(value = "删除商品")
    @ApiImplicitParam(name = "id", value = "商品id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result<Boolean> removeGoods(@PathVariable(value = "id") Integer id) {
        return new Result<>(productService.removeProduct(id));
    }

    @ApiIgnore
    @ApiOperation(value = "查询商品列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String queryGoods(ModelMap map) {
        try {
            map.put("list", productService.queryProduct().getData());
        } catch (Exception e) {
            log.error("{}", e.getMessage(), e);
        }
        return "product";
    }
}
