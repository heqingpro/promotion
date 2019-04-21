package cn.ipanel.apps.interactive.window.feign;

import cn.ipanel.apps.interactive.window.global.MyFeignRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * The type Controller aop.
 * @author luzh
 */
@Slf4j
@Aspect
@Component
public class FeignServiceAop {

	@Pointcut("execution(public cn.ipanel.apps.interactive.window.feign.FeignResult *(..))")
	public void feignServiceAop() {
	}

	@AfterReturning(value = "feignServiceAop()", returning = "retVal")
	public void doSomeThing(FeignResult<?> retVal) throws RuntimeException {
		if(!retVal.getCode().equals(FeignResult.SUCCESS)) {
			log.error("feign error: {}", retVal.getMessage());
			throw new MyFeignRuntimeException(retVal.getMessage(), retVal.getCode());
		}
	}
}
