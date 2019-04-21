package cn.ipanel.apps.marketing.campaign.service.controller;

import cn.ipanel.apps.marketing.campaign.service.controller.resp.Result;
import cn.ipanel.apps.marketing.campaign.service.entity.AreaInfo;
import cn.ipanel.apps.marketing.campaign.service.global.Globals;
import cn.ipanel.apps.marketing.campaign.service.service.IAreaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/7/4 下午3:26
 * Modified By:
 * Description:
 */
@RequestMapping("/area")
@RestController
public class AreaController {

    private IAreaService areaService;

    @Autowired
    public AreaController(IAreaService areaService) {
        this.areaService = areaService;
    }

    @ApiOperation(value = "查询所有分公司", tags = Globals.API_BACK)
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result<List<AreaInfo>> queryAreas() {
        return new Result<>(areaService.queryAll());
    }
}
