package cn.ipanel.apps.interactive.window.controller.resp.back;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/26 下午5:39
 * Modified By:
 * Description:
 */
@Data
public class UserMessageVO {
    @ApiModelProperty(value = "模板名称", required = true)
    private String mouldName;
    @ApiModelProperty(value = "消息生成时间", required = true)
    private String createTime;
    @ApiModelProperty(value = "是否弹窗", required = true)
    private String hasPop;
    @ApiModelProperty(value = "弹窗时间", required = true)
    private String popTime;
    @ApiModelProperty(value = "是否点击按钮", required = true)
    private String hasResponse;
    @ApiModelProperty(value = "点击时间", required = true)
    private String responseTime;
    @ApiModelProperty(value = "操作按钮", required = true)
    private String response;
}
