package com.chstore.ca.employee.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class ProductDTO {

    private UUID id;

    private String name;
    private String titleDescription;
    private String description;
}
