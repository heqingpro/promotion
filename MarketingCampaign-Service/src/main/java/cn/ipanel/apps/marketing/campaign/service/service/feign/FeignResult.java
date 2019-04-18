package cn.ipanel.apps.marketing.campaign.service.service.feign;

import lombok.Data;

import java.io.Serializable;

/**
 * @author luzh
 */
@Data
public class FeignResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String SUCCESS = "000";
    public static final String FAIL = "-1";
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
    }

    public FeignResult(Throwable e) {
        super();
        this.message = e.toString();
        this.code = EXCEPTION;
    }
}
