package org.moon.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.moon.common.annotation.TableSplitRule;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 策略拦截器
 *
 * @author YCKJ3275
 */
@Slf4j(topic = "策略拦截器【ValueSplitInterceptor】")
@Component
public class ValueSplitInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("进入拦截器：====================");
        if(! (handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod method = (HandlerMethod) handler;

        TableSplitRule tableSplitRule = method.getMethod().getAnnotation(TableSplitRule.class);
        tableSplitRule.targetName();
        System.out.println("=============");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

