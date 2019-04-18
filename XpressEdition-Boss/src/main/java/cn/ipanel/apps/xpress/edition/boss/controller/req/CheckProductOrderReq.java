package cn.ipanel.apps.xpress.edition.boss.controller.req;

import cn.ipanel.apps.xpress.edition.boss.controller.resp.CustomerVO;
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
    private String hdFlag = "0";

    public CheckProductOrderReq(CustomerVO customerVO, String productId, String hdFlag) {
        this.customerVO = customerVO;
        this.productId = productId;
        this.hdFlag = hdFlag;
    }
}
