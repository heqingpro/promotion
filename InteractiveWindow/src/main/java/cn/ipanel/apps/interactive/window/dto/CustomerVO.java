package cn.ipanel.apps.interactive.window.dto;

import lombok.Data;

/**
 * @author luzh
 */
@Data
public class CustomerVO {
    // 营销活动需要用户分公司信息
    private String companyName;
    private String customerNo;
    private String stbCode;
    private String subscriberId;

    public CustomerVO() {
    }
}
