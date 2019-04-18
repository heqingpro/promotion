package cn.ipanel.apps.xpress.edition.management.controller.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/8 上午11:29
 * Modified By:
 * Description:
 */
@Data
public class MouldBackVO {
    @ApiModelProperty(value = "模板序号", required = true)
    private Integer id;
    @ApiModelProperty(value = "模板名称", required = true)
    private String name;
    @ApiModelProperty(value = "模板内容", required = true)
    private String content;
    @ApiModelProperty(value = "模板标题", required = true)
    private String title;
    @ApiModelProperty(value = "模板编号", required = true)
    private String code;
    @ApiModelProperty(value = "生效时间", required = true)
    private String effectiveDate;
    @ApiModelProperty(value = "过期时间", required = true)
    private String expireDate;
    @ApiModelProperty(value = "按钮1名称", required = true)
    private String button1Name;
    @ApiModelProperty(value = "按钮1链接地址")
    private String button1Url;
    @ApiModelProperty(value = "按钮2名称")
    private String button2Name;
    @ApiModelProperty(value = "按钮2链接地址")
    private String button2Url;
    @ApiModelProperty(value = "按钮3名称")
    private String button3Name;
    @ApiModelProperty(value = "按钮3链接地址")
    private String button3Url;
}
