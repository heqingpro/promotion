package cn.ipanel.apps.xpress.edition.management.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogHttpRequestParameter {

    /**
     * @return 是否打印参数
     */
    public boolean logParameter() default true;
}
