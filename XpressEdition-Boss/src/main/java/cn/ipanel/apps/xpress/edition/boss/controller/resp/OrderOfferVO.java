package cn.ipanel.apps.xpress.edition.boss.controller.resp;

import com.xmbtn.boss.qfee.server.HsOfferVO;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/30 下午4:05
 * Modified By:
 * Description:
 */
@Data
public class OrderOfferVO {
    private String endTime;
    private String orderType;

    public OrderOfferVO(HsOfferVO offerVO) {
        this.endTime = offerVO.getEndtime();
        this.orderType = offerVO.getOrder_type();
    }
}
