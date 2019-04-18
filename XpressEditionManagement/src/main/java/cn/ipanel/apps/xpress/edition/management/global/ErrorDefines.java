package cn.ipanel.apps.xpress.edition.management.global;

/**
 * Created with Intellij IDEA.
 *
 * @author luzhihao
 * Create: 2018-05-16 下午9:26
 * Modified By:
 * Description:
 */
public enum  ErrorDefines {
    REQUEST_PARAMS_ERROR("100", "参数错误"),
    REQUEST_INTERFACE_COMMON_ERROR("101", "请求接口错误"),
    VOD_ORDER_INQUIRY("299", "点播订购询价为0"),
    VOD_ORDER_NO_TICKET("201", "没有可用的点播券"),
    COMBO_ORDER_INSTESTABLE("301", "用户没有订购资格");

    private String code;
    private String message;

    ErrorDefines(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
