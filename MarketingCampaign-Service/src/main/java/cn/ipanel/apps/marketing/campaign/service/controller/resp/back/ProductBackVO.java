package cn.ipanel.apps.marketing.campaign.service.controller.resp.back;

import cn.ipanel.apps.marketing.campaign.service.entity.ProductInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/23 下午3:03
 * Modified By:
 * Description:
 */
@Data
public class ProductBackVO {
    @ApiModelProperty(value = "产品ID", required = true)
    private Integer id;
    @ApiModelProperty(value = "产品名称", required = true)
    private String name;
    @ApiModelProperty(value = "产品编号", required = true)
    private String code;

    public ProductBackVO(ProductInfo productInfo) {
        this.id = productInfo.getId();
        this.name = productInfo.getProductName();
        this.code = productInfo.getProductCode();
    }
}
