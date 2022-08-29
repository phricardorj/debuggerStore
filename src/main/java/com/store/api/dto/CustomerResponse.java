package com.store.api.dto;

import com.store.api.domain.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class CustomerResponse {
    public UUID customerCode;
    private String name;
    private String document;

    public static CustomerResponse converter(Customer customer) {
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCustomerCode(customer.getCustomerCode());
        customerResponse.setName(customer.getName());
        customerResponse.setDocument(customer.getDocument());

        return customerResponse;
    }

}
