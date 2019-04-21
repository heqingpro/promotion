package cn.ipanel.apps.xpress.edition.management.controller;

import cn.ipanel.apps.xpress.edition.management.annotation.LogHttpRequestParameter;
import cn.ipanel.apps.xpress.edition.management.annotation.LogHttpRequestResult;
import cn.ipanel.apps.xpress.edition.management.controller.request.activity.Type1Req;
import cn.ipanel.apps.xpress.edition.management.controller.request.activity.Type2Req;
import cn.ipanel.apps.xpress.edition.management.controller.response.*;
import cn.ipanel.apps.xpress.edition.management.entity.ActivityTypeEnum;
import cn.ipanel.apps.xpress.edition.management.feign.IActivityManageService;
import cn.ipanel.apps.xpress.edition.management.feign.IActivityAreaService;
import cn.ipanel.apps.xpress.edition.management.feign.IGoodsService;
import cn.ipanel.apps.xpress.edition.management.feign.IProductService;
import com.google.gson.Gson;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/16 下午3:36
 * Modified By:
 * Description:
 */
@Slf4j
@Controller
@RequestMapping(value = "/activity/activity")
public class ActivityManageController {

    private IActivityManageService activityManageService;
    private IGoodsService goodsService;
    private IProductService productService;
    private IActivityAreaService areaService;

    @Autowired
    public ActivityManageController(IActivityManageService activityManageService, IGoodsService goodsService,
                                    IProductService productService, IActivityAreaService areaService) {
        this.activityManageService = activityManageService;
        this.goodsService = goodsService;
        this.productService = productService;
        this.areaService = areaService;
    }

    @ApiIgnore
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String queryActivity(ModelMap map) {
        try {
            List<ActivityBackVO> allList = activityManageService.queryActivity().getData();
            List<ActivityBackVO> type1List = allList.stream().filter(activityBackVO -> activityBackVO.getEnType().equals(ActivityTypeEnum.TIYAN.getType())).collect(Collectors.toList());
            map.put("goods", goodsService.queryGoods().getData());
            map.put("list", allList);
            map.put("type1List", type1List);
            map.put("product", productService.queryProduct().getData());
            map.put("areaList", areaService.queryArea().getData());
        } catch (Exception e) {
            log.error("{}", e.getMessage(), e);
        }
        return "activity";
    }

    @ApiOperation(value = "查询类型1的活动信息")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "type1/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<Type1ActivityBackVO> queryType1Activity(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(activityManageService.queryType1Activity(id));
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @ApiOperation(value = "添加活动类型1")
    @RequestMapping(value = "type1", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> addType1Activity(@RequestBody Type1Req req) throws Exception {
        log.info("{}", new Gson().toJson(req));
        return new Result<>(activityManageService.addType1Activity(req));
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @ApiOperation(value = "修改活动类型1")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "type1/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result<Boolean> modifyType1Activity(@PathVariable(value = "id") Integer id, @RequestBody Type1Req req) throws Exception {
        return new Result<>(activityManageService.modifyType1Activity(id, req));
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @ApiOperation(value = "删除活动类型1")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "type1/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result<Boolean> removeType1Activity(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(activityManageService.removeType1Activity(id));
    }

    @ApiOperation(value = "查询类型2的活动信息")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "type2/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result<Type2ActivityBackVO> queryType2Activity(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(activityManageService.queryType2Activity(id));
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @ApiOperation(value = "添加活动类型2")
    @RequestMapping(value = "type2", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> addType2Activity(@RequestBody Type2Req req) throws Exception {
        return new Result<>(activityManageService.addType2Activity(req));
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @ApiOperation(value = "修改活动类型2")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "type2/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result<Boolean> modifyType2Activity(@PathVariable(value = "id") Integer id, @RequestBody Type2Req req) throws Exception {
        return new Result<>(activityManageService.modifyType2Activity(id, req));
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @ApiOperation(value = "删除活动类型2")
    @RequestMapping(value = "type2/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result<Boolean> removeType2Activity(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(activityManageService.removeType2Activity(id));
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @ApiOperation(value = "活动上线")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "publish/up/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> online(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(activityManageService.online(id));
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @ApiOperation(value = "活动下线")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "publish/down/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> offline(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(activityManageService.offline(id));
    }

    @RequestMapping(value = "online", method = RequestMethod.GET)
    @ResponseBody
    public DataTablesVO<ActivityBackVO> queryOnline(HttpServletRequest httpServletRequest) {
        String draw = httpServletRequest.getParameter("draw");
        return new DataTablesVO<>(Integer.parseInt(draw), activityManageService.queryOnline().getData());
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @ApiOperation(value = "增加优先级")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "priorityLevel/up/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> priorityLevelUp(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(activityManageService.priorityLevelUp(id));
    }

    @LogHttpRequestParameter
    @LogHttpRequestResult
    @ApiOperation(value = "降低优先级")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "priorityLevel/down/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> priorityLevelDown(@PathVariable(value = "id") Integer id) throws Exception {
        return new Result<>(activityManageService.priorityLevelDown(id));
    }
}
