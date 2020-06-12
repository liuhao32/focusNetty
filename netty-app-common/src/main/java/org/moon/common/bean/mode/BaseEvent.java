package org.moon.common.bean.mode;

import java.lang.annotation.Annotation;

/**
 * @author YCKJ3275
 */
public class BaseEvent {
    private Annotation annotation;

    public Annotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Annotation annotation) {
        this.annotation = annotation;
    }
}
