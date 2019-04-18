package cn.ipanel.apps.marketing.campaign.service.controller.resp.back;

import cn.ipanel.apps.marketing.campaign.service.entity.GoodsInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/8/20 下午3:32
 * Modified By:
 * Description:
 */
@Data
public class GoodsBackVO {
    @ApiModelProperty(value = "商品Id", required = true)
    private Integer id;
    @ApiModelProperty(value = "名称", required = true)
    private String name;
    @ApiModelProperty(value = "编号", required = true)
    private String code;

    public GoodsBackVO(GoodsInfo goodsInfo) {
        this.id = goodsInfo.getId();
        this.name = goodsInfo.getGoodsName();
        this.code = goodsInfo.getGoodsCode();
    }
}
