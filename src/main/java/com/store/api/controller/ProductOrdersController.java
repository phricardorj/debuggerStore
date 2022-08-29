package com.store.api.controller;

import com.store.api.dto.ProductOrderResponse;
import com.store.api.dto.ProductOrdersRequest;
import com.store.api.service.ProductOrdersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/store/order")
public class ProductOrdersController {

    private final ProductOrdersService productOrdersService;

    @PostMapping()
    public ProductOrderResponse create(@RequestBody ProductOrdersRequest productOrdersRequest){
        return productOrdersService.create(productOrdersRequest);
    }

    @GetMapping
    public List<ProductOrderResponse> getOrders() {
        return productOrdersService.getAllOrders();
    }

    @GetMapping("/{document}")
    public List<ProductOrderResponse> getOrderByDocument(@PathVariable String document){
        return productOrdersService.getOrderByDocument(document);
    }

}
