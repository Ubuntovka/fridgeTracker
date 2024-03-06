package com.example.springmdb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("Product")
public class Product {

    @Id
    private String id;
    private Fridge fridge;
    private String productName;
    private LocalDate expiredDate;
    private final LocalDate purchaseDate;
    private String storeName;

    public Product(String id, Fridge fridge, String productName, LocalDate expiredDate, String storeName) {
        super();
        this.id = id;
        this.fridge = fridge;
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

    public Fridge getFridge(){
        return fridge;
    }
     public void setFridge(Fridge fridge){
        this.fridge = fridge;
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

//    public void setPurchaseDate(LocalDate purchaseDate) {
//        this.purchaseDate = purchaseDate;
//    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
