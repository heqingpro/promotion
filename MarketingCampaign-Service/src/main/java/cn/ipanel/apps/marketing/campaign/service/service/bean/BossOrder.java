package cn.ipanel.apps.marketing.campaign.service.service.bean;

import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/9/30 下午4:36
 * Modified By:
 * Description: 请求boss订购相关参数
 */
@Data
public class BossOrder {
    private String user;
    private String offerId;
    private String orderDate;
    private String endDate;
    private String orderResult;

}
