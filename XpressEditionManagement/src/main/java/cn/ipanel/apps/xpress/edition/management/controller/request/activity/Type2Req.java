package cn.ipanel.apps.xpress.edition.management.controller.request.activity;

import cn.ipanel.apps.xpress.edition.management.annotation.MyInterfaceRequestParams;
import cn.ipanel.apps.xpress.edition.management.global.Globals;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/16 下午3:25
 * Modified By:
 * Description:
 */
@Data
@MyInterfaceRequestParams(operationType = "添加/修改", operationName = "体验续订活动")
public class Type2Req {
    @ApiModelProperty(value = "活动名称", required = true)
    private String name;
    @ApiModelProperty(value = "活动编号", required = true)
    private String code;
    @ApiModelProperty(value = "活动类别", required = true)
    private String category;
    @ApiModelProperty(value = "失效时间", required = true)
    private String expireDate;
    @ApiModelProperty(value = "生效时间", required = true)
    private String effectiveDate;
    @ApiModelProperty(value = "活动商品", required = true)
    private Integer goodsId;
    @ApiModelProperty(value = "弹窗显示内容", required = true)
    private String introduce;
    @ApiModelProperty(value = "关联体验类型活动ID", required = true)
    private Integer correlationType1ActivityId;
    @ApiModelProperty(value = "体验活动到期提前提醒天数")
    private Integer advanceRemindDay;
    @ApiModelProperty(value = "订购时长", required = true)
    private Integer orderLength;

    public String getExpireDate() {
        return Globals.isEmpty(expireDate) ? "" : expireDate + " 23:59:59";
    }

    public String getEffectiveDate() {
        return Globals.isEmpty(effectiveDate) ? "" : effectiveDate + " 00:00:00";
    }

    public String getIntroduce() {
        return introduce != null ? introduce.length() >= 255 ? introduce.substring(0, 254) : introduce : null;
    }
}
