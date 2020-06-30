package org.moon.service;

import lombok.extern.slf4j.Slf4j;
import org.moon.common.annotation.OrderHandlerType;
import org.moon.common.bean.dto.Order;
import org.moon.common.handler.OrderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrderService {
    private Map<String, OrderHandler> orderHandleMap;
    @Autowired
    public void setOrderHandleMap(List<OrderHandler> orderHandlers) {
        // 注入各种类型的订单处理类
        log.info("注入各种类型的订单处理类:"+orderHandlers);
        orderHandleMap = orderHandlers.stream().collect(
                Collectors.toMap(orderHandler -> AnnotationUtils.findAnnotation(orderHandler.getClass(), OrderHandlerType.class).source(),
                        v -> v, (v1, v2) -> v1));
    }

    public void orderService(Order order) {
        // ...一些前置处理

        // 通过订单来源确定对应的handler
        OrderHandler orderHandler = orderHandleMap.get(order.getSource());
        orderHandler.handle(order);

        // ...一些后置处理
    }
}
