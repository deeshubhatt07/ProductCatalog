package com.product.ProductCatalog.models;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private String category;
    private String imageUrl;
    private BigDecimal discountPrice;
    private Boolean availability;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
