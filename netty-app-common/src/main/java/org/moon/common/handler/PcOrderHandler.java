package org.moon.common.handler;

import org.moon.common.annotation.OrderHandlerType;
import org.moon.common.bean.dto.Order;


@OrderHandlerType(source = "pc")
public class PcOrderHandler implements OrderHandler {

    @Override
    public void handle(Order order) {
        System.out.println("处理PC端订单");
    }
}