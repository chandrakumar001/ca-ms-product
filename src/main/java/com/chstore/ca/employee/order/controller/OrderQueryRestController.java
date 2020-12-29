package com.chstore.ca.employee.order.controller;

import com.chstore.ca.employee.order.dto.OrderDTO;
import com.chstore.ca.employee.order.service.OrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderQueryRestController {

    @Autowired
    OrderQueryService orderQueryService;

    @GetMapping("v1/orders")
    public List<OrderDTO> getAllOrders() {

        return orderQueryService.getAllOrders();
    }

    @GetMapping("v1/orders/{order-id}")
    public OrderDTO getOrdersByOrderId(
            @RequestParam(name = "order-id") String ordersId
    ) {
        return orderQueryService.getOrderById(ordersId);
    }

    @GetMapping("v1/orders/{user-id}")
    public List<OrderDTO> getAllOrdersByUserId(
            @RequestParam(name = "user-id") String userId
    ) {
        return orderQueryService.getAllOrdersByUserId(userId);
    }
}
