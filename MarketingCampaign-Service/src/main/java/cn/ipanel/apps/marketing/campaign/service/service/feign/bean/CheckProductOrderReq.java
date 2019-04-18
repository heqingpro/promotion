package cn.ipanel.apps.marketing.campaign.service.service.feign.bean;

import cn.ipanel.apps.marketing.campaign.service.dto.CustomerVO;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/20 下午7:43
 * Modified By:
 * Description:
 */
@Data
public class CheckProductOrderReq {
    private CustomerVO customerVO;
    private String productId;
    private String hdFlag;

    public CheckProductOrderReq(CustomerVO customerVO, String productId, String hdFlag) {
        this.customerVO = customerVO;
        this.productId = productId;
        this.hdFlag = hdFlag;
    }
}
