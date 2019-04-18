package cn.ipanel.apps.interactive.window.service.bean;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created with Intellij IDEA.
 *
 * @author luzh
 * Create: 2018/10/10 下午3:18
 * Modified By:
 * Description:
 */
@Data
public class ExcelData {
    private String user;
    private String area;
    private String hdComboType;
    private String comboName;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate endDateMonthBegin;
    private LocalDate endDateMonthEnd;
    private Boolean success;
    private String errorMessage;
}
