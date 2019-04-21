package cn.ipanel.apps.xpress.edition.boss.global;

/**
 * Created with Intellij IDEA.
 *
 * @author luzhihao
 * Create: 2018-04-13 上午11:55
 * Modified By:
 * Description:
 */
public class MyCommonException extends Exception {
    private static final long serialVersionUID = 8576208755379159809L;
    private String code;

    public MyCommonException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
