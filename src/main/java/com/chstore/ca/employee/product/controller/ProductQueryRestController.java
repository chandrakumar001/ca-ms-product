package com.chstore.ca.employee.product.controller;

import com.chstore.ca.employee.product.dto.ProductDTO;
import com.chstore.ca.employee.product.service.ProductQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@Tag(name = "Product")
public class ProductQueryRestController {

    @Autowired
    ProductQueryService chRequestContext;

    @GetMapping("v1/products")
    public List<ProductDTO> getProducts() {
        return chRequestContext.getProducts();
    }

    @GetMapping("v1/products/{product-id}")
    public ProductDTO getProductsById(
            @PathVariable(name = "product-id") String productId
    ) {
        return chRequestContext.getProductsById(productId);
    }

    @GetMapping("v1/products1/{product-id}")
    public ProductDTO getProductsById1(
            @PathVariable(name = "product-id") String productId
    ) {
        throw new RuntimeException();
    }
}




