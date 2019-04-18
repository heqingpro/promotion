package cn.ipanel.apps.xpress.edition.management.controller.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/20 上午10:44
 * Modified By:
 * Description:
 */
@Data
public class UserFilterVO {
    @ApiModelProperty(value = "序号", required = true)
    private Integer id;
    @ApiModelProperty(value = "用户CA卡", required = true)
    private String user;
}
