package cn.ipanel.apps.marketing.campaign.service.controller.resp.back;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/19 下午2:43
 * Modified By:
 * Description:
 */
@Data
public class ActivityStatisticsVO {
    @ApiModelProperty(value = "弹窗数", required = true)
    private Long popNumber;
    @ApiModelProperty(value = "用户数", required = true)
    private Long userNumber;
    @ApiModelProperty(value = "同意数", required = true)
    private Long agreeNumber;
    @ApiModelProperty(value = "拒绝数", required = true)
    private Long disagreeNumber;
    @ApiModelProperty(value = "每日统计数")
    private List<ActivityStatisticsItemVO> list;
}
