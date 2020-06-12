package org.moon.common.listener;

import org.moon.common.bean.mode.BaseEvent;
import org.springframework.stereotype.Component;


/**
 * @author YCKJ3275
 */
@Component
public interface BaseListener<T> {

    /** listener
     * @param event 消息
     *  @return void
     */
    void onListener(BaseEvent event);
}
