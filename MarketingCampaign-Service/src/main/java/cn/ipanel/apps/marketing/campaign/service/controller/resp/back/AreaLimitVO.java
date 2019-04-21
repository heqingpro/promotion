package cn.ipanel.apps.marketing.campaign.service.controller.resp.back;

import cn.ipanel.apps.marketing.campaign.service.entity.AreaInfo;
import cn.ipanel.apps.marketing.campaign.service.entity.AreaLimit;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/14 下午4:33
 * Modified By:
 * Description:
 */
@Data
public class AreaLimitVO {
    @ApiModelProperty(value = "区域id", required = true)
    private Integer areaId;
    @ApiModelProperty(value = "区域限额", required = true)
    private Integer areaLimitNumber;
    @ApiModelProperty(value = "区域名称", required = true)
    private String areaName;

    public AreaLimitVO(AreaLimit areaLimit) {
        this.areaId = areaLimit.getAreaId();
        this.areaLimitNumber = areaLimit.getAreaLimitNumber();
        this.areaName = null != areaLimit.getAreaInfo() ? areaLimit.getAreaInfo().getAreaName() : "-";
    }

    public AreaLimitVO(AreaInfo areaInfo) {
        this.areaId = areaInfo.getId();
        this.areaName = areaInfo.getAreaName();
        this.areaLimitNumber = 0;
    }
}
