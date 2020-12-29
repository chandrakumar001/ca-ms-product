package com.chstore.ca.employee.order.controller;

import com.chstore.ca.employee.order.dto.OrderDTO;
import com.chstore.ca.employee.order.service.OrderCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderCommandRestController {

    @Autowired
    OrderCommandService orderCommandService;

    @PostMapping("v1/orders")
    public OrderDTO createOrders(@RequestBody final OrderDTO orderDTO) {

        return orderCommandService.createOrder(orderDTO);
    }

    @PutMapping("v1/orders/{order-id}")
    public String updateOrdersByOrderId(
            @RequestParam(name = "order-id") String ordersId
    ) {
        return null;
    }

    @DeleteMapping("v1/orders/{order-id}")
    public String deleteOrdersByOrderId(
            @RequestParam(name = "order-id") String orderId
    ) {
        return null;
    }

}
