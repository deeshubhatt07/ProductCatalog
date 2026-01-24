package com.product.ProductCatalog.util;

import com.product.ProductCatalog.models.Product;
import com.product.ProductCatalog.models.ProductRequest;
import com.product.ProductCatalog.models.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setCategory(request.getCategory());
        product.setImageUrl(request.getImageUrl());
        product.setDiscountPrice(request.getDiscountPrice());
        product.setAvailability(request.getAvailability());
        return product;
    }

    public ProductResponse toResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setQuantity(product.getQuantity());
        response.setCategory(product.getCategory());
        response.setImageUrl(product.getImageUrl());
        response.setDiscountPrice(product.getDiscountPrice());
        response.setAvailability(product.getAvailability());
        response.setCreatedAt(product.getCreatedAt());
        response.setUpdatedAt(product.getUpdatedAt());
        return response;
    }

    public void updateEntity(Product product, ProductRequest request) {
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setCategory(request.getCategory());
        product.setImageUrl(request.getImageUrl());
        product.setDiscountPrice(request.getDiscountPrice());
        product.setAvailability(request.getAvailability());
    }
}
