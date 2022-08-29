package com.store.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter @Getter
public class ProductOrdersRequest {
    private List<ProductRequest> products;
    private UUID consumerCode;
}
