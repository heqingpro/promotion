package cn.ipanel.apps.xpress.edition.management.feign;

import cn.ipanel.apps.xpress.edition.management.global.Globals;
import com.netflix.client.ClientException;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

/**
 * @author luzh
 */
@Slf4j
public class FeignResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String SUCCESS = "000";
    public static final String FAIL = "111";
    public static final String EXCEPTION = "500";
    private String message = "success";
    private String code = SUCCESS;
    private T data;

    public FeignResult() {
        super();
    }

    public FeignResult(T data, String message, String code) {
        super();
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public FeignResult(String message, String code) {
        super();
        this.code = code;
        this.message = message;
    }

    public FeignResult(T data) {
        super();
        this.data = data;
        if (data instanceof Boolean) {
            if (!(Boolean) data) {
                this.code = FAIL;
                this.message = "failed";
            }
        }
    }

    public FeignResult(Throwable e) {
        super();
        e = Globals.getOriginException(e);
        if (e instanceof ClientException || e instanceof ConnectException) {
            log.error("503");
            this.message = "系统服务不可用";
            this.code = "503";
        } else if (e instanceof SocketTimeoutException || e instanceof TimeoutException) {
            this.code = "408";
            this.message = "操作超时";
        } else {
            this.message = e.toString();
            this.code = EXCEPTION;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
