package cn.ipanel.apps.marketing.campaign.service.controller;

import cn.ipanel.apps.marketing.campaign.service.controller.req.GoodsReq;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.Result;
import cn.ipanel.apps.marketing.campaign.service.controller.resp.back.GoodsBackVO;
import cn.ipanel.apps.marketing.campaign.service.global.Globals;
import cn.ipanel.apps.marketing.campaign.service.service.IGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/20 下午3:35
 * Modified By:
 * Description:
 */
@Api(tags = Globals.API_BACK)
@RequestMapping(value = "manage/goods")
@RestController
public class GoodsManageController {

    private IGoodsService goodsService;

    @Autowired
    public GoodsManageController(IGoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @ApiOperation(value = "添加商品")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Result<Boolean> addGoods(@RequestBody GoodsReq goodsReq) throws Exception {
        return new Result<>(goodsService.addGoods(goodsReq));
    }

    @ApiOperation(value = "修改商品")
    @ApiImplicitParam(name = "id", value = "商品id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Result<Boolean> modifyGoods(@PathVariable(value = "id") Integer id, @RequestBody GoodsReq req) throws Exception {
        return new Result<>(goodsService.modifyGoods(id, req));
    }

    @ApiOperation(value = "删除商品")
    @ApiImplicitParam(name = "id", value = "商品id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Result<Boolean> removeGoods(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(goodsService.removeGoods(id));
    }

    @ApiOperation(value = "查询商品列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result<List<GoodsBackVO>> queryGoods() {
        return new Result<>(goodsService.queryGoods());
    }
}
