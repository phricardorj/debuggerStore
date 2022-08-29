package com.store.api.repository;

import com.store.api.domain.ProductOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrdersRepository extends JpaRepository<ProductOrders, Long> {
}
