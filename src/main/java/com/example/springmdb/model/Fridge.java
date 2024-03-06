package com.example.springmdb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Fridge")
public class Fridge {

    @Id
    private Long id;

    private String name;

    private boolean isFreezer;

    public Fridge(Long id, String name, boolean isFreezer) {
        super();
        this.id = id;
        this.name = name;
        this.isFreezer = isFreezer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsFreezer() {
        return isFreezer;
    }

    public void setIsFreezer(boolean isFreezer) {
        this.isFreezer = isFreezer;
    }

}
