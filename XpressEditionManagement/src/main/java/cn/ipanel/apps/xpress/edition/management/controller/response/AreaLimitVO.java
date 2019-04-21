package cn.ipanel.apps.xpress.edition.management.controller.response;

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

}
