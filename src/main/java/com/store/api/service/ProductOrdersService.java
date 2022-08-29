package com.store.api.service;

import com.store.api.domain.Customer;
import com.store.api.domain.Product;
import com.store.api.domain.ProductOrders;
import com.store.api.dto.ProductOrderResponse;
import com.store.api.dto.ProductOrdersRequest;
import com.store.api.dto.ProductRequest;
import com.store.api.repository.CustomerRepository;
import com.store.api.repository.ProductOrdersRepository;
import com.store.api.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductOrdersService {

    private final ProductOrdersRepository productOrdersRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public ProductOrderResponse create(ProductOrdersRequest productOrdersRequest) {
        ProductOrders productOrders = new ProductOrders();
        Customer customer = customerRepository.findByCustomerCode(productOrdersRequest.getConsumerCode());
        List<ProductRequest> productRequests = productOrdersRequest.getProducts();

        productOrders.setCustomer(customer);
        productOrders.setProducts(getProductsByCode(productRequests));

        return ProductOrderResponse.converter(productOrdersRepository.save(productOrders));
    }

    private List<Product> getProductsByCode(List<ProductRequest> productRequests){
       List<Product> products = new ArrayList<>();
       for (ProductRequest productRequest : productRequests) {
           Product product = productRepository.findByProductCode(productRequest.getProductCode());
           products.add(product);
       }
       return products;
    }

    public List<ProductOrderResponse> getAllOrders() {
        return productOrdersRepository.findAll().stream().map(ProductOrderResponse::converter).collect(Collectors.toList());
    }

    public List<ProductOrderResponse> getOrderByDocument(String document){
       Customer customer = customerRepository.findByDocument(document);
       return customer.getProductOrdersList().stream().map(ProductOrderResponse::converter).collect(Collectors.toList());
    }

}
