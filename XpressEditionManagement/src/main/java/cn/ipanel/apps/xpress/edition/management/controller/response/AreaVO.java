package cn.ipanel.apps.xpress.edition.management.controller.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/7/4 下午3:39
 * Modified By:
 * Description:
 */
@Data
public class AreaVO {
    @ApiModelProperty(value = "序号")
    private Integer id;
    @ApiModelProperty(value = "名称")
    private String areaName;
    @ApiModelProperty(value = "编号")
    private String code;
}
