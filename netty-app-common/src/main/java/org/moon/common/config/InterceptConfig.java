package org.moon.common.config;

import org.moon.common.base.BaseAnnotationHandler;
import org.moon.common.listener.PermissionListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author YCKJ3275
 */
@Configuration
public class InterceptConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        BaseAnnotationHandler handler = new BaseAnnotationHandler();
        handler.registerListener(PermissionListener.class);

        interceptorRegistry.addInterceptor(handler);
    }

}
