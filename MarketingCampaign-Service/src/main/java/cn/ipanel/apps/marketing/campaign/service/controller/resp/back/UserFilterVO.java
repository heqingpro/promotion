package cn.ipanel.apps.marketing.campaign.service.controller.resp.back;

import cn.ipanel.apps.marketing.campaign.service.entity.UserFilterInfo;
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

    public UserFilterVO(UserFilterInfo info) {
        this.id = info.getId();
        this.user = info.getUser();
    }
}
