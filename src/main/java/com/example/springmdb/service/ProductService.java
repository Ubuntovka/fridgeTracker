package com.example.springmdb.service;

import com.example.springmdb.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    Product getProductById(Long productId);

    List<Product> getProductsByFridge(Long productId);

    Product saveProduct(Product product);

    void deleteProductById(Long productId);

}
