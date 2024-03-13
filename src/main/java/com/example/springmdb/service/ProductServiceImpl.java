package com.example.springmdb.service;


import com.example.springmdb.model.Fridge;
import com.example.springmdb.model.Product;
import com.example.springmdb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByFridge(Long fridgeId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("fridgeId").is(fridgeId));
        return mongoTemplate.find(query, Product.class);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }


}
