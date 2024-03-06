package com.example.springmdb.service;

import com.example.springmdb.model.Fridge;

import java.util.List;


public interface FridgeService {
    List<Fridge> getFridges();

    Fridge getFridgeById(Long id);

    Fridge saveFridge(Fridge fridge);

    void deleteFridgeById(Long id);

}
