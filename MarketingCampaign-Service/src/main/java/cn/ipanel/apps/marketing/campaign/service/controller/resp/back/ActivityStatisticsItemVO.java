package cn.ipanel.apps.marketing.campaign.service.controller.resp.back;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/19 下午2:38
 * Modified By:
 * Description:
 */
@Data
public class ActivityStatisticsItemVO {
    @ApiModelProperty(value = "弹窗数", required = true)
    private Integer popNumber = 0;
    @ApiModelProperty(value = "用户数", required = true)
    private Integer userNumber = 0;
    @ApiModelProperty(value = "同意数", required = true)
    private Integer agreeNumber = 0;
    @ApiModelProperty(value = "拒绝数", required = true)
    private Integer disagreeNumber = 0;
    @ApiModelProperty(value = "日期", required = true)
    private String day;

}
