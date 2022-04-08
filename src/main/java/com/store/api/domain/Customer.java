package com.store.api.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public UUID customerCode = UUID.randomUUID();
    private String name;
    private String document;

    @ManyToMany
    @JoinTable(
            name="client_orders",
            joinColumns = @JoinColumn(name="client_id"),
            inverseJoinColumns = @JoinColumn(name = "orders_id")
    )
    private List<ProductOrders> productOrdersList;

}
