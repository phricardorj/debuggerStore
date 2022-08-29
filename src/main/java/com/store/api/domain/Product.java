package com.store.api.domain;

import javax.persistence.*;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID productCode = UUID.randomUUID();
    private String name;
    private Long productQuantity;
    private BigDecimal price;

}
