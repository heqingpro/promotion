package cn.ipanel.apps.xpress.edition.management.controller;

import cn.ipanel.apps.xpress.edition.management.annotation.LogHttpRequestParameter;
import cn.ipanel.apps.xpress.edition.management.annotation.LogHttpRequestResult;
import cn.ipanel.apps.xpress.edition.management.controller.response.Result;
import cn.ipanel.apps.xpress.edition.management.global.*;
import cn.ipanel.apps.xpress.edition.management.util.IpHelper;
import com.netflix.client.ClientException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.SocketTimeoutException;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Controller aop.
 * @author luzh
 */
@Aspect
@Component
public class ControllerAop {

	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAop.class);

	@Pointcut("execution(public cn.ipanel.apps.xpress.edition.management.controller.response.Result *(..))")
	public void controllerAop() {
	}

	@Before(value = "controllerAop()")
	public void doBefore(JoinPoint jp) {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (null == servletRequestAttributes) {
			return;
		}
		// 打印请求ip、url等基础信息
		HttpServletRequest request = servletRequestAttributes.getRequest();
		LOGGER.info("IP {} | {}_REQUEST {} | METHOD {}. USER: {}",
				IpHelper.getIpAddress(request),
				request.getMethod(),
				request.getRequestURL().toString(),
				getRequestMethodName(jp),
				null != SecurityUtils.getSubject().getPrincipal() ? SecurityUtils.getSubject().getPrincipal() : "NONE_USER");

		try {
			logRequestParams(jp);
		} catch (Throwable e) {
			LOGGER.error("{} LOGGER request args error: {}.", getRequestMethodName(jp), e.getMessage(), e);
		}
	}

	private void logRequestParams(JoinPoint jp) {
		// 判断是否打印请求参数
		MethodSignature methodSignature = (MethodSignature) jp.getSignature();
		Method method = methodSignature.getMethod();
		// 方法或者参数是否打印到log共用一个注解
		// 方法只有添加了注解才打印，默认所有参数都打印出来
		// 如果参数添加注解并设置为false则不打印该请求的参数
		LogHttpRequestParameter isLogMethod = method.getAnnotation(LogHttpRequestParameter.class);
		// 没加注解或者设置为false时不打印参数
		if (null == isLogMethod || !isLogMethod.logParameter()) {
			return;
		}
		Parameter[] parameters = method.getParameters();
		LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
		String[] parameterNames = discoverer.getParameterNames(method);
		if (null == parameters || null == parameterNames || parameters.length == 0 || parameterNames.length == 0 || jp.getArgs().length == 0) {
			LOGGER.info("{} request not args.", getRequestMethodName(jp));
			return;
		}
		Map<String, Object> map = new HashMap<>();
		// 前面获取到的参数在数组中一般都是按照方法中的参数顺序排列的，所以直接按照对应位置取名称和值就行
		// 暂未考虑全特殊情况，所以分两种情况打印或者出现数组不对应问题，仅供分析请求数据时简单参考
		if (parameters.length == jp.getArgs().length && parameters.length == parameterNames.length) {
			for (int i = 0; i < parameters.length; i++) {
				Parameter parameter = parameters[i];
				if (ModelMap.class.getName().equals(parameter.getType().getName())) {
					continue;
				}
				LogHttpRequestParameter isLogParam = parameter.getAnnotation(LogHttpRequestParameter.class);
				if (null == isLogParam || isLogParam.logParameter()) {
					map.put(parameterNames[i], null == jp.getArgs()[i] ? Globals.SYSTEM_DEFINES_NULL_OBJ : jp.getArgs()[i].toString());
				}
			}
			LOGGER.info("{} request args: {}.", getRequestMethodName(jp), map.toString());
		} else {
			LOGGER.info("{} request params: {}, values: {}.", getRequestMethodName(jp), parameterNames, Arrays.toString(jp.getArgs()));
		}
	}

	private String getRequestMethodName(JoinPoint jp) {
		return jp.getTarget().getClass().getSimpleName() + "." + jp.getSignature().getName();
	}

	@Around(value = "controllerAop()")
	public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
		long startTime = Instant.now().toEpochMilli();
		Result<?> result;
		try {
			result = (Result<?>) pjp.proceed();
			LOGGER.info("{} use time {} ms.", getRequestMethodName(pjp), Instant.now().toEpochMilli() - startTime);
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
		} else if (e instanceof MyFeignRuntimeException) {
			result.setCode(((MyFeignRuntimeException) e).getCode());
			result.setMessage(e.getMessage());
		} else if (e instanceof ClientException) {
			result.setCode("9002");
			result.setMessage("系统服务不可用");
		} else {
			result.setMessage(e.toString());
			result.setCode(Result.EXCEPTION_CODE);
			LOGGER.error("{}", e.getMessage(), e);
		}
		LOGGER.error("{} error: {} ", getRequestMethodName(pjp), e.getMessage());
		return result;
	}

	@AfterReturning(returning = "res", pointcut = "controllerAop()")
	public void printRequestResultToLog(JoinPoint jp, Object res) {
		MethodSignature methodSignature = (MethodSignature) jp.getSignature();
		Method method = methodSignature.getMethod();
		// 如果方法所在的类是Controller注解并且方法没有ResponseBody注解的话为返回html页面，不打印返回内容
		Controller controller = method.getDeclaringClass().getAnnotation(Controller.class);
		if (null != controller) {
			ResponseBody responseBody = method.getAnnotation(ResponseBody.class);
			if (null == responseBody) {
				return;
			}
		}
		if (Void.TYPE.getTypeName().equals(method.getReturnType().getTypeName())) {
			return;
		}
		// 没加注解或者设置为false时不打印返回内容
		LogHttpRequestResult isLog = method.getAnnotation(LogHttpRequestResult.class);
		if (null != isLog && isLog.logResult()) {
			LOGGER.info("{} result: {}.", getRequestMethodName(jp), null == res? Globals.SYSTEM_DEFINES_NULL_OBJ : res.toString());
		}
	}
}
