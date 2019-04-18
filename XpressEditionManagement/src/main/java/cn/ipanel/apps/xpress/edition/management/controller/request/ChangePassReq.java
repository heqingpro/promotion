package cn.ipanel.apps.xpress.edition.management.controller.request;

import cn.ipanel.apps.xpress.edition.management.annotation.MyInterfaceRequestParams;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/20 下午3:57
 * Modified By:
 * Description:
 */
@Data
@MyInterfaceRequestParams(operationType = "修改", operationName = "修改密码")
public class ChangePassReq {
    @ApiModelProperty(value = "旧密码", required = true)
    private String oldPass;
    @ApiModelProperty(value = "新密码", required = true)
    private String newPass;
}
