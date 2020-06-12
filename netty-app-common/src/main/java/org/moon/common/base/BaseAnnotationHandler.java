package org.moon.common.base;

import org.moon.common.bean.mode.BaseEvent;
import org.moon.common.listener.BaseListener;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author YCKJ3275
 */
public class BaseAnnotationHandler<T extends Annotation> extends HandlerInterceptorAdapter {

    private Map<String, Class> listeners = new ConcurrentHashMap<String, Class>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Annotation[] annotations = handlerMethod.getMethod().getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                String className = annotation.annotationType().getName();
                Class clazz = listeners.get(className);
                if (clazz != null) {
                    BaseEvent event = new BaseEvent();
                    event.setAnnotation(annotation);
                    ((BaseListener)clazz.newInstance()).onListener(event);
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    public void registerListener(Class clazz) {
        Type[] types = clazz.getGenericInterfaces();
        ParameterizedTypeImpl type = (ParameterizedTypeImpl) types[0];
        String annotationName = ((Class) type.getActualTypeArguments()[0]).getName();

        listeners.put(annotationName, clazz);
    }
}
