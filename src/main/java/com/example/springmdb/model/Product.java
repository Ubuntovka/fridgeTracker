package com.example.springmdb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("Product")
public class Product {

    @Id
    private String id;
    private Fridge fridgeId;
    private String productName;
    private LocalDate expiredDate;
    private final LocalDate purchaseDate;
    private String storeName;

    public Product(String id, Fridge fridgeId, String productName, LocalDate expiredDate, String storeName) {
        super();
        this.id = id;
        this.fridgeId = fridgeId;
        this.productName = productName;
        this.expiredDate = expiredDate;
        this.purchaseDate = LocalDate.now();
        this.storeName = storeName;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Fridge getFridgeId(){
        return fridgeId;
    }
     public void setFridgeId(Fridge fridgeId){
        this.fridgeId = fridgeId;
     }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }
    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
