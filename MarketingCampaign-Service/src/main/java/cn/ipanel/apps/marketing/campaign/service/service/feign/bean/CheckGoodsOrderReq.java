package cn.ipanel.apps.marketing.campaign.service.service.feign.bean;

import cn.ipanel.apps.marketing.campaign.service.dto.CustomerVO;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/20 下午7:29
 * Modified By:
 * Description:
 */
@Data
public class CheckGoodsOrderReq {
    private CustomerVO customerVO;
    private String goodsId;

    public CheckGoodsOrderReq(CustomerVO customerVO, String goodsId) {
        this.customerVO = customerVO;
        this.goodsId = goodsId;
    }
}
