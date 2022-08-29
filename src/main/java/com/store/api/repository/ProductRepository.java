package com.store.api.repository;

import com.store.api.domain.Product;
import com.store.api.dto.ProductRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductCode(UUID productCode);
}
