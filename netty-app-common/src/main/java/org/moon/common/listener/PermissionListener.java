package org.moon.common.listener;

import lombok.extern.slf4j.Slf4j;
import org.moon.common.annotation.Permission;
import org.moon.common.bean.mode.BaseEvent;

/**
 * @author YCKJ3275
 */
@Slf4j(topic = "【Permission拦截器】")
public class PermissionListener implements BaseListener<Permission> {

    @Override
    public void onListener(BaseEvent event) {

        log.info(event.toString());
    }
}
