package cn.ipanel.apps.xpress.edition.management.controller.request;

import cn.ipanel.apps.xpress.edition.management.annotation.MyInterfaceRequestParams;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzhihao
 * Create: 2018-05-23 下午5:43
 * Modified By:
 * Description:
 */
@Data
@MyInterfaceRequestParams(operationName = "添加管理员")
public class ManagerReq {
    @ApiModelProperty(value = "账号", required = true)
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    @ApiModelProperty(value = "姓名", required = true)
    private String name;
    @ApiModelProperty(value = "权限", required = true)
    private String roles;

    public ManagerReq() {
    }
}

