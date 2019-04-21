package cn.ipanel.apps.marketing.campaign.service.controller.resp.tv;

import cn.ipanel.apps.marketing.campaign.service.entity.ActivityInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/14 下午5:05
 * Modified By:
 * Description:
 */
@Data
public class ActivityTVVO {
    @ApiModelProperty(value = "弹窗序列号", required = true)
    private String serialNumber;
    @ApiModelProperty(value = "活动介绍", required = true)
    private String introduce;
    @ApiModelProperty(value = "活动ID", required = true)
    private Integer activityId;
    @ApiModelProperty(value = "弹窗生成时间", required = true)
    private Long popTime;
    @ApiModelProperty(value = "类型", required = true)
    private String type;

    public ActivityTVVO(ActivityInfo activityInfo, String serialNumber, Long popTime) {
        this.serialNumber = serialNumber;
        this.activityId = activityInfo.getId();
        this.introduce = activityInfo.getIntroduce();
        this.popTime = popTime;
        this.type = activityInfo.getActivityType().replaceAll("type", "");
    }
}
