package org.moon.common.handler;

import org.moon.common.annotation.OrderHandlerType;
import org.moon.common.bean.dto.Order;

@OrderHandlerType(source = "mobile")
public class MobileOrderHandler implements OrderHandler {

    @Override
    public void handle(Order order) {
        System.out.println("处理移动端订单");
    }
}
