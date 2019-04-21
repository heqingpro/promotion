package cn.ipanel.apps.marketing.campaign.service.controller.req.activity;

import cn.ipanel.apps.marketing.campaign.service.annotation.MyInterfaceRequestParams;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/16 下午3:21
 * Modified By:
 * Description:
 */
@Data
@MyInterfaceRequestParams(operationType = "添加/修改", operationName = "体验类型活动")
public class Type1Req {
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
    @ApiModelProperty(value = "同类型活动参加次数上限")
    private Integer maxType1JoinTimes;
    @ApiModelProperty(value = "必须已订购校验类型", required = true)
    private String mustOrderType;
    @ApiModelProperty(value = "必须已订购的信息")
    private List<String> mustOrderInfo;
    @ApiModelProperty(value = "校验已订购信息的方式", required = true)
    private String checkMustOrderMode;
    @ApiModelProperty(value = "必须未订购校验类型", required = true)
    private String mustNotOrderType;
    @ApiModelProperty(value = "必须未订购的信息")
    private List<String> mustNotOrderInfo;
    @ApiModelProperty(value = "校验未订购信息的方式", required = true)
    private String checkMustNotOrderMode;
    @ApiModelProperty(value = "是否开启限额", required = true)
    private String openLimit;
    @ApiModelProperty(value = "每日总限额")
    private Integer limitNumber = 0;
    @ApiModelProperty(value = "按区域开启限额", required = true)
    private String limitByArea;
    @ApiModelProperty(value = "区域限额列表")
    private List<AreaLimitReq> areaLimit;
    @ApiModelProperty(value = "是否开启用户名单过滤", required = true)
    private Boolean openFilter;
    @ApiModelProperty(value = "订购时长", required = true)
    private Integer orderLength;
}
