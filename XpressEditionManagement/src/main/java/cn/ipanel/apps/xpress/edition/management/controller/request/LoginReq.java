package cn.ipanel.apps.xpress.edition.management.controller.request;

import cn.ipanel.apps.xpress.edition.management.annotation.MyInterfaceRequestParams;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzhihao
 * Create: 2018-05-27 下午11:43
 * Modified By:
 * Description:
 */
@MyInterfaceRequestParams(operationName = "登录")
@Data
public class LoginReq {
    private String username;
    private String password;
}
