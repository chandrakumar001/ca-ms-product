package com.chstore.ca.employee.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class OrderDTO {

    private UUID orderId;
    private UUID cardId;
    private UUID userId;
}
