package org.moon.common.handler;

import lombok.extern.slf4j.Slf4j;
import org.moon.common.annotation.Permission;
import org.moon.common.base.BaseAnnotationHandler;
import org.springframework.stereotype.Component;

/**
 * @author YCKJ3275
 */
@Component
@Slf4j(topic = "【Permission拦截器】")
public class PermissionHandler extends BaseAnnotationHandler<Permission> {

}
