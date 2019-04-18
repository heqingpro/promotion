package cn.ipanel.apps.xpress.edition.management.controller.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/22 上午10:51
 * Modified By:
 * Description:
 */
@Data
public class ActivityBackVO {
    @ApiModelProperty(value = "活动类型英文", required = true)
    private String enType;
    @ApiModelProperty(value = "活动类型", required = true)
    private String type;
    @ApiModelProperty(value = "活动促销类别", required = true)
    private String category;
    @ApiModelProperty(value = "活动促销类别英文")
    private String enCategory;
    @ApiModelProperty(value = "活动ID", required = true)
    private Integer id;
    @ApiModelProperty(value = "活动编号", required = true)
    private String code;
    @ApiModelProperty(value = "活动名称", required = true)
    private String name;
    @ApiModelProperty(value = "是否上线", required = true)
    private String publish;
    @ApiModelProperty(value = "生效时间", required = true)
    private String effectiveDate;
    @ApiModelProperty(value = "失效时间", required = true)
    private String expireDate;
    @ApiModelProperty(value = "活动商品名称", required = true)
    private String goodsName;

}
