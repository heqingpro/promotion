package cn.ipanel.apps.xpress.edition.management.controller.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/18 上午11:52
 * Modified By:
 * Description:
 */
@Data
public class MouldStatisticsVO {
    @ApiModelProperty(value = "按钮1名称")
    private String button1Name;
    @ApiModelProperty(value = "按钮2名称")
    private String button2Name;
    @ApiModelProperty(value = "按钮3名称")
    private String button3Name;
    private List<MouldStatisticsItemVO> list;
}
