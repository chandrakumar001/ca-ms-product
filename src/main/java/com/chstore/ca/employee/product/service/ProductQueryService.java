package com.chstore.ca.employee.product.service;

import com.chstore.ca.employee.CommonException;
import com.chstore.ca.employee.product.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductQueryService {

    public List<ProductDTO> getProducts() {

        ProductDTO product = getProductDTO(UUID.randomUUID());
        return List.of(product);
    }

    public ProductDTO getProductsById(final String productId) {

        validateAndGetErrorMsg(productId)
                .ifPresent(CommonException::fieldValidationException);
        if (productId.equals("123456")) {
            throw new RuntimeException();
        }
        return getProductDTO(UUID.fromString(productId));
    }

    private Optional<String> validateAndGetErrorMsg(final String productId) {

        try {
            UUID.fromString(productId);
        } catch (Exception e) {
            return Optional.of("UUID is invalid format");
        }
        return Optional.empty();
    }

    private ProductDTO getProductDTO(UUID uuid) {

        ProductDTO product = new ProductDTO();
        product.setId(uuid);
        product.setName("Product name");
        product.setDescription("PRD1");
        product.setTitleDescription("USB");
        return product;
    }
}