package com.store.api.dto;

import com.store.api.domain.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter @Setter
public class ProductResponse {
    private UUID productCode;
    private String name;
    private Long productQuantity;
    private BigDecimal price;

    public static ProductResponse converter(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductCode(product.getProductCode());
        productResponse.setName(product.getName());
        productResponse.setProductQuantity(product.getProductQuantity());
        productResponse.setPrice(product.getPrice());

        return productResponse;
    }
}
