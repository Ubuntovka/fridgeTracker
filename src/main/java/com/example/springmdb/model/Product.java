package com.example.springmdb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("Product")
public class Product {

    @Id
    private Long id;
    private Long fridgeId;
    private String productName;
    private String expiredDate;
    private LocalDate purchaseDate;
    private String storeName;

    public Product(Long id, Long fridgeId, String productName, String expiredDate, String storeName) {
        super();
        this.id = id;
        this.fridgeId = fridgeId;
        this.productName = productName;
//        this.expiredDate = LocalDate.parse(expiredDate);
        this.expiredDate = expiredDate;
        this.purchaseDate = LocalDate.now();
        this.storeName = storeName;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getFridgeId(){
        return fridgeId;
    }
     public void setFridgeId(Long fridgeId){
        this.fridgeId = fridgeId;
     }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getExpiredDate() {
        return expiredDate;
    }
    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(){
        this.purchaseDate = LocalDate.now();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
