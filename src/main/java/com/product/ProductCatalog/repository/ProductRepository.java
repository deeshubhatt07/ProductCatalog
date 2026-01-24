package com.product.ProductCatalog.repository;

import com.product.ProductCatalog.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(String category);

    List<Product> findByNameContainingIgnoreCase(String name);

    Optional<Product> findByNameAndCategory(String name, String category);

    boolean existsByNameAndCategory(String name, String category);
}
