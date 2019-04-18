package cn.ipanel.apps.xpress.edition.boss.controller.resp;

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

    public CustomerVO(String companyName, String customerNo, String stbCode, String subscriberId) {
        this.companyName = companyName;
        this.customerNo = customerNo;
        this.stbCode = stbCode;
        this.subscriberId = subscriberId;
    }
}
