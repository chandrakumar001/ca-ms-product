package com.chstore.ca.employee.product.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class Product {

    private UUID id;
    private String description;
    private String name;
}
