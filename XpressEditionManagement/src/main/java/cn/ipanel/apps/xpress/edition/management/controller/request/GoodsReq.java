package cn.ipanel.apps.xpress.edition.management.controller.request;

import cn.ipanel.apps.xpress.edition.management.annotation.MyInterfaceRequestParams;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/20 下午3:07
 * Modified By:
 * Description:
 */
@MyInterfaceRequestParams(operationType = "添加/修改", operationName = "商品")
@Data
@EqualsAndHashCode
public class GoodsReq {
    @ApiModelProperty(value = "商品名称", required = true)
    private String goodsName;
    @ApiModelProperty(value = "商品编号", required = true)
    private String goodsCode;
}
