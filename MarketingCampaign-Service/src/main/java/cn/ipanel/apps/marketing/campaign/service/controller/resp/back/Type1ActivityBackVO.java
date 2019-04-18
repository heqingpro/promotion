package cn.ipanel.apps.marketing.campaign.service.controller.resp.back;

import cn.ipanel.apps.marketing.campaign.service.entity.*;
import cn.ipanel.apps.marketing.campaign.service.global.Globals;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
public class Type1ActivityBackVO {
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
    @ApiModelProperty(value = "同类型活动参加次数上限")
    private Integer maxType1JoinTimes;
    @ApiModelProperty(value = "已订购校验类型", required = true)
    private String mustOrderType;
    @ApiModelProperty(value = "必须已订购的信息")
    private List<String> mustOrderInfo;
    @ApiModelProperty(value = "校验已订购信息的方式")
    private String checkMustOrderMode;
    @ApiModelProperty(value = "未订购校验类型", required = true)
    private String mustNotOrderType;
    @ApiModelProperty(value = "必须未订购的信息")
    private List<String> mustNotOrderInfo;
    @ApiModelProperty(value = "校验未订购信息的方式")
    private String checkMustNotOrderMode;
    @ApiModelProperty(value = "活动商品名称", required = true)
    private String goodsName;
    @ApiModelProperty(value = "活动商品ID", required = true)
    private Integer goodsId;
    @ApiModelProperty(value = "是否开启限额", required = true)
    private String openLimit;
    @ApiModelProperty(value = "每日总限额", required = true)
    private Integer limitNumber = 0;
    @ApiModelProperty(value = "按区域开启限额", required = true)
    private String limitByArea;
    @ApiModelProperty(value = "区域限额列表")
    private List<AreaLimitVO> areaLimit;
    @ApiModelProperty(value = "是否开启用户过滤名单")
    private String openFilter;
    @ApiModelProperty(value = "订购时长", required = true)
    private Integer orderLength;

    public Type1ActivityBackVO(ActivityInfo activityInfo, Type1ActivityInfo type1ActivityInfo, List<AreaLimitVO> defaultList) {
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
        this.maxType1JoinTimes = type1ActivityInfo.getMaxType1JoinTimes();
        this.mustOrderType = type1ActivityInfo.getMustOrderType();
        this.mustOrderInfo = Type1ActivityUtil.convertMustOrderInfo(type1ActivityInfo);
        this.checkMustOrderMode = type1ActivityInfo.getCheckMustOrderMode();
        this.mustNotOrderType = type1ActivityInfo.getMustNotOrderType();
        this.mustNotOrderInfo = Type1ActivityUtil.convertMustNotOrderInfo(type1ActivityInfo);
        this.checkMustNotOrderMode = type1ActivityInfo.getCheckMustNotOrderMode();
        this.goodsName = null != activityInfo.getGoodsInfo() ? activityInfo.getGoodsInfo().getGoodsName() : "---";
        this.goodsId = activityInfo.getGoodsId();
        this.openLimit = type1ActivityInfo.getOpenLimit() + "";
        this.limitNumber = type1ActivityInfo.getLimitNumber();
        this.limitByArea = type1ActivityInfo.getLimitByArea() + "";
        this.areaLimit = null != type1ActivityInfo.getAreaLimits() && !type1ActivityInfo.getAreaLimits().isEmpty()
                ? type1ActivityInfo.getAreaLimits().stream().map(AreaLimitVO::new).collect(Collectors.toList())
                : defaultList;
        this.openFilter = type1ActivityInfo.getOpenFilter() + "";
        this.orderLength = type1ActivityInfo.getOrderLength();
    }
}
