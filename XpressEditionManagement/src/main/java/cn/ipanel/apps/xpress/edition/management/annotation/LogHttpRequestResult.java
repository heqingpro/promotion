package cn.ipanel.apps.xpress.edition.management.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogHttpRequestResult {

    /**
     * @return 是否打印返回结果
     */
    public boolean logResult() default true;
}