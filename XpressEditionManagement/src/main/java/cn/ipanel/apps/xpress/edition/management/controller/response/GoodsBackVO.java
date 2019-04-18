package cn.ipanel.apps.xpress.edition.management.controller.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/20 下午3:32
 * Modified By:
 * Description:
 */
@Data
public class GoodsBackVO {
    @ApiModelProperty(value = "商品Id", required = true)
    private Integer id;
    @ApiModelProperty(value = "名称", required = true)
    private String name;
    @ApiModelProperty(value = "编号", required = true)
    private String code;

}
