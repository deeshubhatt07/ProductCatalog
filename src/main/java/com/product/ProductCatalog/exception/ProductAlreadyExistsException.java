package com.product.ProductCatalog.exception;

public class ProductAlreadyExistsException extends RuntimeException {

    public ProductAlreadyExistsException(String message) {
        super(message);
    }

    public ProductAlreadyExistsException(String name, String category) {
        super("Product already exists with name: " + name + " in category: " + category);
    }
}
