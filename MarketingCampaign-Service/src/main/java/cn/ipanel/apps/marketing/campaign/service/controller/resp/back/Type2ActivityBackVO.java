package cn.ipanel.apps.marketing.campaign.service.controller.resp.back;

import cn.ipanel.apps.marketing.campaign.service.entity.*;
import cn.ipanel.apps.marketing.campaign.service.global.Globals;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/24 下午2:46
 * Modified By:
 * Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Type2ActivityBackVO {
    @ApiModelProperty(value = "活动类型英文", required = true)
    private String enType;
    @ApiModelProperty(value = "活动类型", required = true)
    private String type;
    @ApiModelProperty(value = "活动促销类别", required = true)
    private String category;
    @ApiModelProperty(value = "活动促销类别英文")
    private String enCategory;
    @ApiModelProperty(value = "活动ID", required = true)
    private Integer id;
    @ApiModelProperty(value = "活动编号", required = true)
    private String code;
    @ApiModelProperty(value = "活动名称", required = true)
    private String name;
    @ApiModelProperty(value = "是否上线", required = true)
    private String publish;
    @ApiModelProperty(value = "生效时间", required = true)
    private String effectiveDate;
    @ApiModelProperty(value = "失效时间", required = true)
    private String expireDate;
    @ApiModelProperty(value = "弹窗显示内容", required = true)
    private String introduce;
    @ApiModelProperty(value = "活动商品名称", required = true)
    private String goodsName;
    @ApiModelProperty(value = "活动商品ID", required = true)
    private Integer goodsId;
    @ApiModelProperty(value = "关联体验类型的活动ID", required = true)
    private Integer correlationType1ActivityId;
    @ApiModelProperty(value = "关联体验类型的活动名称", required = true)
    private String correlationType1ActivityName;
    @ApiModelProperty(value = "到期续订提前提醒天数")
    private Integer advanceRemindDay;

    public Type2ActivityBackVO(ActivityInfo activityInfo, Type2ActivityInfo type2ActivityInfo) {
        this.enType = activityInfo.getActivityType();
        this.type = ActivityTypeEnum.typeName(activityInfo.getActivityType());
        this.enCategory = activityInfo.getActivityCategory();
        this.category = ActivityCategoryEnum.categoryName(activityInfo.getActivityCategory());
        this.id = activityInfo.getId();
        this.code = activityInfo.getCode();
        this.name = activityInfo.getName();
        this.publish = activityInfo.getPublish() ? "上线" : "下线";
        this.effectiveDate = Globals.formatterDateTime(activityInfo.getEffectiveDate());
        this.expireDate = Globals.formatterDateTime(activityInfo.getExpireDate());
        this.introduce = activityInfo.getIntroduce();
        this.goodsName = null != activityInfo.getGoodsInfo() ? activityInfo.getGoodsInfo().getGoodsName() : "---";
        this.goodsId = activityInfo.getGoodsId();
        this.correlationType1ActivityId = type2ActivityInfo.getCorrelationType1ActivityId();
        this.correlationType1ActivityName = null != type2ActivityInfo.getCorrelationType1ActivityInfo() ? type2ActivityInfo.getCorrelationType1ActivityInfo().getName() : "---";
        this.advanceRemindDay = type2ActivityInfo.getAdvanceRemindDay();
    }
}
