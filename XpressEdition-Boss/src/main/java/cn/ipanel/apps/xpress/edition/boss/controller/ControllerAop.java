package cn.ipanel.apps.xpress.edition.boss.controller;

import cn.ipanel.apps.xpress.edition.boss.controller.resp.Result;
import cn.ipanel.apps.xpress.edition.boss.global.*;
import cn.ipanel.apps.xpress.edition.boss.util.IpHelper;
import com.netflix.client.ClientException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.SocketTimeoutException;
import java.time.Instant;

/**
 * The type Controller aop.
 * @author luzh
 */
@Slf4j
@Aspect
@Component
public class ControllerAop {

	@Pointcut(value = "execution(public cn.ipanel.apps.xpress.edition.boss.controller.resp.Result *(..))")
	public void controllerAop() {
	}

	@Before(value = "controllerAop()")
	public void doBefore(JoinPoint joinPoint) {
		// 接收到请求，记录请求内容
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		if (null == requestAttributes) {
			return;
		}
		HttpServletRequest request = requestAttributes.getRequest();

		// 记录下请求内容
		log.info("IP: {}, RequestURL: {}, RequestMethod: {}, MethodName: {}.",
				IpHelper.getIpAddress(request),
				request.getRequestURI(),
				request.getMethod(),
				getRequestMethodName(joinPoint));
	}

	private String getRequestMethodName(JoinPoint pjp) {
		return pjp.getTarget().getClass().getSimpleName() + " " + pjp.getSignature().getName();
	}

	@Around(value = "controllerAop()")
	public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
		long startTime = Instant.now().toEpochMilli();
		Result<?> result;
		try {
			result = (Result<?>) pjp.proceed();
			log.info("{} use time {} ms.", getRequestMethodName(pjp), Instant.now().toEpochMilli() - startTime);
		} catch (Throwable e) {
			result = handlerException(pjp, e);
		}
		return result;
	}

	private Result<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
		Result<?> result = new Result<>();
		e = Globals.getOriginException(e);
		if (e instanceof RequestParamErrorException) {
			result.setMessage(e.getMessage());
			result.setCode(ErrorDefines.REQUEST_PARAMS_ERROR.getCode());
		} else if(e instanceof MyCommonException) {
			result.setCode(((MyCommonException) e).getCode());
			result.setMessage(e.getMessage());
		} else if (e instanceof SocketTimeoutException) {
			result.setMessage("操作超时");
			result.setCode("9001");
		} else if (e instanceof MyRunException) {
			result.setCode(((MyRunException) e).getCode());
			result.setMessage(e.getMessage());
		} else if (e instanceof ClientException) {
			result.setCode("9002");
			result.setMessage("系统服务不可用");
		} else {
			result.setMessage(e.toString());
			result.setCode(Result.EXCEPTION);
		}
		log.error("{} error: {} ", getRequestMethodName(pjp), e.getMessage());
		return result;
	}
}
