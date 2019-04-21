package cn.ipanel.apps.xpress.edition.management.controller.request;

import cn.ipanel.apps.xpress.edition.management.annotation.MyInterfaceRequestParams;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/12 下午3:10
 * Modified By:
 * Description:
 */
@Data
@MyInterfaceRequestParams(operationType = "添加/修改", operationName = "产品")
public class ProductReq {
    @ApiModelProperty(value = "产品名称", required = true)
    private String productName;
    @ApiModelProperty(value = "产品编号", required = true)
    private String productCode;
}
