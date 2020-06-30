package org.moon.common.handler;

import org.moon.common.bean.dto.Order;

/**
 * @author YCKJ3275
 */
public interface OrderHandler {
    /**
     * 订单处理
     * @param order 订单
     */
    void handle(Order order);
}
