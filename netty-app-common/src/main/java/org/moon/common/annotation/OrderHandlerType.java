package org.moon.common.annotation;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @author YCKJ3275
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface OrderHandlerType {
    String source();
}
