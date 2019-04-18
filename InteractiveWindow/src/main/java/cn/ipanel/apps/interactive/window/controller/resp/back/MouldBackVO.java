package cn.ipanel.apps.interactive.window.controller.resp.back;

import cn.ipanel.apps.interactive.window.entity.MouldInfo;
import cn.ipanel.apps.interactive.window.global.Globals;
import io.swagger.annotations.ApiImplicitParam;
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
    @ApiModelProperty(value = "过期时间", required = true)
    private String expireDate;
    @ApiModelProperty(value = "模板优先级", required = true)
    private Integer priorityLevel;
    @ApiModelProperty(value = "生效时间", required = true)
    private String effectiveDate;
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
    @ApiModelProperty(value = "按钮个数")
    private Integer buttonNumber = 1;

    public MouldBackVO(MouldInfo mouldInfo) {
        this.id = mouldInfo.getId();
        this.name = mouldInfo.getName();
        this.content = mouldInfo.getContent();
        this.title = mouldInfo.getTitle();
        this.code = mouldInfo.getCode();
        this.expireDate = Globals.formatterDateTime(mouldInfo.getExpireDate());
        this.effectiveDate = Globals.formatterDateTime(mouldInfo.getEffectiveDate());
        this.priorityLevel = mouldInfo.getPriorityLevel();
        this.button1Name = mouldInfo.getButton1Name();
        this.button1Url = mouldInfo.getButton1Url();
        this.button2Name = mouldInfo.getButton2Name();
        this.button2Url = mouldInfo.getButton2Url();
        this.button3Name = mouldInfo.getButton3Name();
        this.button3Url = mouldInfo.getButton3Url();
        if (!Globals.isEmpty(button2Name)) {
            this.buttonNumber = 2;
        }
        if (!Globals.isEmpty(button3Name)) {
            this.buttonNumber = 3;
        }
    }
}
