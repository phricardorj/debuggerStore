package com.store.api.controller;

import com.store.api.domain.Product;
import com.store.api.dto.ProductResponse;
import com.store.api.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/store/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody Product product) {
        productService.create(product);
        return new ResponseEntity<>("Product registered successfully", HttpStatus.OK);
    }

    @GetMapping
    public List<ProductResponse> getAllProducts(@RequestParam(defaultValue = "0") Integer pageNo,
                                                @RequestParam(defaultValue = "2") Integer pageSize) {
        return productService.getAllProducts(pageNo, pageSize);
    }

    @GetMapping("/{productCode}")
    public ProductResponse getAllProducts(@PathVariable UUID productCode) {
        return productService.getProductByCode(productCode);
    }

}
