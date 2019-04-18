package cn.ipanel.apps.marketing.campaign.service.service.feign;

import cn.ipanel.apps.marketing.campaign.service.global.MyFeignRuntimeException;
import com.google.gson.Gson;
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

	@Pointcut("execution(public cn.ipanel.apps.marketing.campaign.service.service.feign.FeignResult *(..))")
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
