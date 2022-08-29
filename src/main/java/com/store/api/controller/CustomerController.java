package com.store.api.controller;

import com.store.api.domain.Customer;
import com.store.api.dto.CustomerResponse;
import com.store.api.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/store/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody Customer customer) {
        customerService.create(customer);
        return new ResponseEntity<>("Client registered successfully", HttpStatus.OK);
    }

    @GetMapping
    public List<CustomerResponse> getCustomers(@RequestParam(defaultValue = "0") Integer pageNo,
                                               @RequestParam(defaultValue = "2") Integer pageSize) {

        return customerService.getCustomers(pageNo, pageSize);
    }

}
