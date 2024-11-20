package com.mohitgupta.yummyapp.mapper;

import com.mohitgupta.yummyapp.dto.ProductRequest;
import com.mohitgupta.yummyapp.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct (ProductRequest request) {
        return Product.builder()
                .name(request.name())
                .price(request.price())
                .build();
    }
}
