package cn.ipanel.apps.marketing.campaign.service.dto;

import lombok.Data;

/**
 * @author luzh
 */
@Data
public class CustomerVO implements java.io.Serializable {
    // 营销活动需要用户分公司信息
    private String companyName;
    private String customerNo;
    private String stbCode;
    private String subscriberId;

    public CustomerVO() {
    }
}
