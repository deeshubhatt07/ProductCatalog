package com.product.ProductCatalog.service;

import com.product.ProductCatalog.exception.ProductAlreadyExistsException;
import com.product.ProductCatalog.exception.ProductNotFoundException;
import com.product.ProductCatalog.models.Product;
import com.product.ProductCatalog.models.ProductRequest;
import com.product.ProductCatalog.models.ProductResponse;
import com.product.ProductCatalog.repository.ProductRepository;
import com.product.ProductCatalog.util.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public ProductResponse createProduct(ProductRequest request) {
        if (productRepository.existsByNameAndCategory(request.getName(), request.getCategory())) {
            throw new ProductAlreadyExistsException(request.getName(), request.getCategory());
        }
        Product product = productMapper.toEntity(request);
        Product savedProduct = productRepository.save(product);
        return productMapper.toResponse(savedProduct);
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return productMapper.toResponse(product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> getProductsByCategory(String category) {
        return productRepository.findByCategory(category)
                .stream()
                .map(productMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> searchProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(productMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        productMapper.updateEntity(product, request);
        Product updatedProduct = productRepository.save(product);
        return productMapper.toResponse(updatedProduct);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
    }
}
