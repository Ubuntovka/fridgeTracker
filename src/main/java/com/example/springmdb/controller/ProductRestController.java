package com.example.springmdb.controller;

import com.example.springmdb.model.Product;
import com.example.springmdb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/")
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping(value = "/byId/{productId}")
    public Product getProductById(@PathVariable("productId") long productId){
        return productService.getProductById(productId);
    }

    @GetMapping(value = "/byFridgeId/{fridgeId}")
    public ArrayList<Product> getProductByFridgeId(@PathVariable("fridgeId") long fridgeId) {
        return (ArrayList<Product>) productService.getProductsByFridge(fridgeId);
    }

    @PostMapping(value = "/save")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }


    @DeleteMapping(value = "/delete/{productId}")
    public ResponseEntity<?> deleteProductById(@PathVariable long productId) {
        productService.deleteProductById(productService.getProductById(productId).getId());
        return new ResponseEntity<>("Fridge deleted successfully", HttpStatus.OK);
    }

}
