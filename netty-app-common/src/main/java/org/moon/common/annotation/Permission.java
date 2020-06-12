package org.moon.common.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author YCKJ3275
 */
@Component
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface Permission {
    /** 进行权限过滤的操作类型 用户所拥有的权限集仅需要1项权限符合 */
    String OPER_OR = "OR";
    /** 进行权限过滤的操作类型 用户所拥有的权限集需要覆盖全部 */
    String OPER_AND = "AND";

    /**
     * 需求的权限的操作模式，默认为OR
     */
    String oper() default OPER_OR;

    /** 需要的权限 */
    String[] value() default {};
}
