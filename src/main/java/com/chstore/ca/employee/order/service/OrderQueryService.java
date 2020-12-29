package com.chstore.ca.employee.order.service;

import com.chstore.ca.employee.order.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderQueryService {

    public List<OrderDTO> getAllOrdersByUserId(String userId) {

        OrderDTO reviewDTO = getOrderDTO(UUID.fromString(userId));
        return List.of(reviewDTO);
    }

    public List<OrderDTO> getAllOrders() {

        OrderDTO reviewDTO = getOrderDTO(UUID.randomUUID());
        return List.of(reviewDTO);
    }

    public OrderDTO getOrderById(String reviewId) {

        return getOrderDTO(UUID.fromString(reviewId));
    }


    private OrderDTO getOrderDTO(UUID uuid) {

        OrderDTO reviewDTO = new OrderDTO();
        reviewDTO.setCardId(UUID.randomUUID());
        reviewDTO.setOrderId(UUID.randomUUID());
        reviewDTO.setUserId(UUID.randomUUID());
        return reviewDTO;
    }
}
