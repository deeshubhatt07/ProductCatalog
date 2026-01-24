package com.product.ProductCatalog.service;

import com.product.ProductCatalog.models.ProductRequest;
import com.product.ProductCatalog.models.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductRequest request);

    ProductResponse getProductById(Long id);

    List<ProductResponse> getAllProducts();

    List<ProductResponse> getProductsByCategory(String category);

    List<ProductResponse> searchProductsByName(String name);

    ProductResponse updateProduct(Long id, ProductRequest request);

    void deleteProduct(Long id);
}
