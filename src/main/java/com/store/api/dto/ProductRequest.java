package com.store.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter @Getter
public class ProductRequest {
    private UUID productCode;
    private Integer productQuantity;
}
