package cn.ipanel.apps.xpress.edition.management.controller.response;

import cn.ipanel.apps.xpress.edition.management.feign.FeignResult;
import lombok.Data;

/**
 * Created with Intellij IDEA.
 *
 * @author luzhihao
 * Create: 2018-04-21 上午11:11
 * Modified By:
 * Description:
 */
@Data
public class Result<T> {
    public static final String EXCEPTION_CODE = "500";
    private static final String SUCCESS_MESSAGE = "success";
    private static final String SUCCESS_CODE = "000";
    private static final String FAILED_MESSAGE = "failed";
    private static final String FAILED_CODE = "-1";
    private String code = SUCCESS_CODE;
    private String message = SUCCESS_MESSAGE;
    private T data;

    public Result(T data) {
        this.data = data;
        if (data instanceof Boolean && !(Boolean) data) {
            this.code = FAILED_CODE;
            this.message = FAILED_MESSAGE;
        }
    }

    public Result(T data, String message) {
        this.data = data;
        if (data instanceof Boolean && !(Boolean) data) {
            this.code = FAILED_CODE;
            this.message = FAILED_MESSAGE;
        }
        this.message = message;
    }

    public Result(FeignResult<T> feignResult) {
        this.code = feignResult.getCode();
        this.data = feignResult.getData();
        this.message = feignResult.getMessage();
    }

    public Result() {
    }

    public Result(String msg, String code) {
        this.message = msg;
        this.code = code;
    }
}
