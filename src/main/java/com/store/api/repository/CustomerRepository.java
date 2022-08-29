package com.store.api.repository;

import com.store.api.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByDocument(String document);
    Customer findByCustomerCode(UUID customerCode);
}
