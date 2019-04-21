package cn.ipanel.apps.xpress.edition.boss.controller.req;

import cn.ipanel.apps.xpress.edition.boss.controller.resp.CustomerVO;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/20 下午7:47
 * Modified By:
 * Description:
 */
@Data
public class BuyOfferReq {
    private CustomerVO customerInfo;
    private String offerId;
    private String operatorCode;
    private String startTime;
    private String endTime;

    public BuyOfferReq(CustomerVO customerInfo, String offerId, String operatorCode, String startTime, String endTime) {
        this.customerInfo = customerInfo;
        this.offerId = offerId;
        this.operatorCode = operatorCode;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
