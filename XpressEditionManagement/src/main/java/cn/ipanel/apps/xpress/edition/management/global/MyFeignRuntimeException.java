package cn.ipanel.apps.xpress.edition.management.global;

/**
 * @author luzh
 */
public class MyFeignRuntimeException extends RuntimeException {

	private String code;

    public MyFeignRuntimeException(String message, String code) {
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
