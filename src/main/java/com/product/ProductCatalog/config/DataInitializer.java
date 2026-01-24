package com.product.ProductCatalog.config;

import com.product.ProductCatalog.models.Product;
import com.product.ProductCatalog.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final ProductRepository productRepository;

    @PostConstruct
    public void init() {
        if (productRepository.count() == 0) {
            List<Product> products = Arrays.asList(
                    createProduct("iPhone 15 Pro", "Latest Apple smartphone with A17 chip", new BigDecimal("999.99"), new BigDecimal("949.99"), 50, "Electronics", "https://example.com/iphone15.jpg", true),
                    createProduct("Samsung Galaxy S24", "Flagship Android smartphone", new BigDecimal("899.99"), new BigDecimal("849.99"), 45, "Electronics", "https://example.com/galaxys24.jpg", true),
                    createProduct("MacBook Pro 14", "Apple laptop with M3 Pro chip", new BigDecimal("1999.99"), null, 30, "Electronics", "https://example.com/macbook14.jpg", true),
                    createProduct("Dell XPS 15", "Premium Windows laptop", new BigDecimal("1499.99"), new BigDecimal("1299.99"), 25, "Electronics", "https://example.com/dellxps15.jpg", true),
                    createProduct("Sony WH-1000XM5", "Noise cancelling headphones", new BigDecimal("349.99"), new BigDecimal("299.99"), 100, "Electronics", "https://example.com/sonywh1000xm5.jpg", true),
                    createProduct("Nike Air Max 90", "Classic running shoes", new BigDecimal("129.99"), new BigDecimal("99.99"), 200, "Footwear", "https://example.com/airmax90.jpg", true),
                    createProduct("Adidas Ultraboost", "Premium running shoes", new BigDecimal("179.99"), null, 150, "Footwear", "https://example.com/ultraboost.jpg", true),
                    createProduct("Levi's 501 Jeans", "Classic fit denim jeans", new BigDecimal("69.99"), new BigDecimal("49.99"), 300, "Clothing", "https://example.com/levis501.jpg", true),
                    createProduct("North Face Jacket", "Waterproof outdoor jacket", new BigDecimal("249.99"), null, 80, "Clothing", "https://example.com/northface.jpg", true),
                    createProduct("Ray-Ban Aviator", "Classic sunglasses", new BigDecimal("154.99"), new BigDecimal("129.99"), 120, "Accessories", "https://example.com/rayban.jpg", true),
                    createProduct("Apple Watch Series 9", "Smartwatch with health features", new BigDecimal("399.99"), new BigDecimal("379.99"), 75, "Electronics", "https://example.com/applewatch9.jpg", true),
                    createProduct("Kindle Paperwhite", "E-reader with backlight", new BigDecimal("139.99"), null, 90, "Electronics", "https://example.com/kindle.jpg", true),
                    createProduct("Instant Pot Duo", "Multi-use pressure cooker", new BigDecimal("89.99"), new BigDecimal("69.99"), 60, "Home & Kitchen", "https://example.com/instantpot.jpg", true),
                    createProduct("Dyson V15 Vacuum", "Cordless vacuum cleaner", new BigDecimal("749.99"), null, 40, "Home & Kitchen", "https://example.com/dysonv15.jpg", true),
                    createProduct("Nespresso Vertuo", "Coffee machine", new BigDecimal("199.99"), new BigDecimal("179.99"), 55, "Home & Kitchen", "https://example.com/nespresso.jpg", true),
                    createProduct("PlayStation 5", "Gaming console", new BigDecimal("499.99"), null, 0, "Gaming", "https://example.com/ps5.jpg", false),
                    createProduct("Xbox Series X", "Gaming console", new BigDecimal("499.99"), new BigDecimal("449.99"), 30, "Gaming", "https://example.com/xboxseriesx.jpg", true),
                    createProduct("Nintendo Switch OLED", "Portable gaming console", new BigDecimal("349.99"), null, 65, "Gaming", "https://example.com/switcholed.jpg", true),
                    createProduct("Fitbit Charge 6", "Fitness tracker", new BigDecimal("159.99"), new BigDecimal("139.99"), 110, "Electronics", "https://example.com/fitbit6.jpg", true),
                    createProduct("Herman Miller Chair", "Ergonomic office chair", new BigDecimal("1395.00"), null, 0, "Furniture", "https://example.com/hermanmiller.jpg", false)
            );
            productRepository.saveAll(products);
        }
    }

    private Product createProduct(String name, String description, BigDecimal price, BigDecimal discountPrice, int quantity, String category, String imageUrl, boolean availability) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setDiscountPrice(discountPrice);
        product.setQuantity(quantity);
        product.setCategory(category);
        product.setImageUrl(imageUrl);
        product.setAvailability(availability);
        return product;
    }
}
