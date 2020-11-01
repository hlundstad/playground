package com.lundstad.products;

import java.util.Collection;

public interface ProductService {
    void createProduct(Product product);

    void updateProduct(int id, Product product);

    void deleteProduct(int id);

    Collection<Product> getProducts();

    Product getProduct(int id);
}
