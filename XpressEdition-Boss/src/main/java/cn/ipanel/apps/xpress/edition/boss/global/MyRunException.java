package cn.ipanel.apps.xpress.edition.boss.global;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with Intellij IDEA.
 *
 * @author luzhihao
 * Create: 2018-05-15 下午9:36
 * Modified By:
 * Description:
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
public class MyRunException extends RuntimeException {
    private static final long serialVersionUID = -6611740776773508996L;

    private String code;

    public MyRunException(Throwable e) {
        super(Globals.getOriginException(e).getMessage());
        Throwable throwable = Globals.getOriginException(e);
        if (throwable instanceof MyRunException) {
            this.code = ((MyRunException) throwable).getCode();
        }
        if (throwable instanceof MyCommonException) {
            this.code = ((MyCommonException) throwable).getCode();

        } else {
            this.code = "500";
        }
        log.error("a new myRunException: code: {}, {}", code, e.getMessage(), e);
    }

    public MyRunException(String message) {
        super(message);
    }
}
