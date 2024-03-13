package com.example.springmdb.repository;

import com.example.springmdb.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Long> {
    Product getProductById(Long id);

}
