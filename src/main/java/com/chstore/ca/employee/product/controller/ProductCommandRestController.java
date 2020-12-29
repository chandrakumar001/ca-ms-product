package com.chstore.ca.employee.product.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Product")
public class ProductCommandRestController {

    @PostMapping("v1/products")
    public String createProduct() {
        return null;
    }

    @PutMapping("v1/products/{product-id}")
    public String updateProduct(
            @RequestParam(name = "product-id") String productId
    ) {
        return null;
    }

    @DeleteMapping("v1/products/{product-id}")
    public String deleteProduct(
            @RequestParam(name = "product-id") String productId
    ) {
        return null;
    }
}
