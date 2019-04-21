package cn.ipanel.apps.xpress.edition.management.feign;

import cn.ipanel.apps.xpress.edition.management.global.MyFeignRuntimeException;
import com.google.gson.Gson;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Controller aop.
 * @author luzh
 */
//@Aspect
//@Component
public class FeignServiceAop {

	private static final Logger logger = LoggerFactory.getLogger(FeignServiceAop.class);

	@Pointcut("execution(public cn.ipanel.apps.xpress.edition.management.feign.FeignResult *(..))")
	public void feignServiceAop() {
	}

	@AfterReturning(value = "feignServiceAop()", returning = "retVal")
	public void doSomeThing(FeignResult<?> retVal) throws RuntimeException {
		logger.info("{}", new Gson().toJson(retVal));
		if(!retVal.getCode().equals(FeignResult.SUCCESS)) {
			throw new MyFeignRuntimeException(retVal.getMessage(), retVal.getCode());
		}
	}
}
