package org.moon.controller;

import org.moon.common.annotation.Permission;
import org.moon.common.bean.dto.Order;
import org.moon.service.OrderService;
import org.moon.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author YCKJ3275
 */
@RestController
//@TableSplitRule(tableName = "tableName", paramName = "paramName", targetName = "targetName")
public class TestController {

    @Resource
    TestService testService;

    @Resource
    OrderService orderService;
    @Permission(value = {"p_menu_edit"})
    @RequestMapping(value = "selectById", method = RequestMethod.POST)
    public void selectById(@RequestParam int id) {
        testService.print(id);
    }

    @Permission(value = {"p_menu_edit"})
    @RequestMapping(value = "selectBy", method = RequestMethod.POST)
    public void selectBy(@RequestParam int id) {
        testService.print(id);
    }

    @RequestMapping(value = "orderService", method = RequestMethod.POST)
    public void orderService() {
        Order order = new Order();
        order.setSource("pc");
        orderService.orderService(order);
    }
}
