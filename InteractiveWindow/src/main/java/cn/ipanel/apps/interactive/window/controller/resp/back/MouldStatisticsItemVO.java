package cn.ipanel.apps.interactive.window.controller.resp.back;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/18 上午11:51
 * Modified By:
 * Description:
 */
@Data
public class MouldStatisticsItemVO {
    @ApiModelProperty(value = "目标用户数", required = true)
    private Long userNumber;
    @ApiModelProperty(value = "弹窗数", required = true)
    private Long popNumber = 0L;
    @ApiModelProperty(value = "按钮1点击数", required = true)
    private Long button1Number = 0L;
    @ApiModelProperty(value = "按钮2点击数", required = true)
    private Long button2Number = 0L;
    @ApiModelProperty(value = "按钮3点击数", required = true)
    private Long button3Number = 0L;
    @ApiModelProperty(value = "日期", required = true)
    private String area;
}
