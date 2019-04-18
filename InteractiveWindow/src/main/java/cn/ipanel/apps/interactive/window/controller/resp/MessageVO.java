package cn.ipanel.apps.interactive.window.controller.resp;

import cn.ipanel.apps.interactive.window.entity.UserMessageInfo;
import cn.ipanel.apps.interactive.window.entity.UserMessageRecordInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/12 上午11:16
 * Modified By:
 * Description:
 */
@Data
public class MessageVO {
    @ApiModelProperty(value = "弹窗序列号", required = true)
    private String serialNumber;
    @ApiModelProperty(value = "弹窗标题", required = true)
    private String title;
    @ApiModelProperty(value = "弹窗内容", required = true)
    private String content;
    @ApiModelProperty(value = "弹窗记录id", required = true)
    private Long recordId;
    @ApiModelProperty(value = "弹窗生成时间", required = true)
    private Long popTime;
    private String button1Name;
    private String button1Url;
    private String button2Name;
    private String button2Url;
    private String button3Name;
    private String button3Url;

    public MessageVO(UserMessageRecordInfo recordInfo, UserMessageInfo messageInfo) {
        this.serialNumber = recordInfo.getSerialNumber();
        this.content = messageInfo.getMessage();
        this.recordId = recordInfo.getId();
        this.title = messageInfo.getMouldInfo().getTitle();
        this.popTime = recordInfo.getPopTime();
        this.button1Name = messageInfo.getMouldInfo().getButton1Name();
        this.button1Url = messageInfo.getMouldInfo().getButton1Url();
        this.button2Name = messageInfo.getMouldInfo().getButton2Name();
        this.button2Url = messageInfo.getMouldInfo().getButton2Url();
        this.button3Name = messageInfo.getMouldInfo().getButton3Name();
        this.button3Url = messageInfo.getMouldInfo().getButton3Url();
    }
}
