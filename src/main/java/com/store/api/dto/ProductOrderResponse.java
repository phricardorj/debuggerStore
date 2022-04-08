package com.store.api.dto;


import com.store.api.domain.Product;
import com.store.api.domain.ProductOrders;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter @Setter
public class ProductOrderResponse {
    private UUID orderCode;
    private UUID customerCode;
    private ZonedDateTime orderTime;
    private List<ProductResponse> products;
    private BigDecimal priceTotal;

    public static ProductOrderResponse converter(ProductOrders productOrders) {
        List<Product> products = productOrders.getProducts();
        List<BigDecimal> prices = products.stream().map(Product::getPrice).toList();
        BigDecimal priceTotal = prices.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

        ProductOrderResponse productOrderResponse = new ProductOrderResponse();
        productOrderResponse.setOrderCode(productOrders.getOrderCode());
        productOrderResponse.setCustomerCode(productOrders.getCustomer().getCustomerCode());
        productOrderResponse.setOrderTime(productOrders.getOrderTime());
        productOrderResponse.setProducts(products.stream().map(ProductResponse::converter).collect(Collectors.toList()));
        productOrderResponse.setPriceTotal(priceTotal);

        return productOrderResponse;
    }
}
