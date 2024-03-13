package com.example.springmdb.service;

import com.example.springmdb.model.Fridge;
import com.example.springmdb.repository.FridgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class FridgeServiceImpl implements FridgeService {

    @Autowired
    private FridgeRepository fridgeRepository;

    @Override
    public List<Fridge> getFridges() {
        return fridgeRepository.findAll();
    }

    @Override
    public Fridge getFridgeById(Long id){
        Fridge fridge = fridgeRepository.getFridgeById(id);
        if (fridge == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fridge with given id " + id + " does not exist");
        return fridge;
    }

    @Override
    public Fridge saveFridge(Fridge fridge) {
        return fridgeRepository.save(fridge);
    }

    @Override
    public void deleteFridgeById(Long id) {
        fridgeRepository.deleteById(id);
    }

    @Override
    public void updateFridge(Long id, Fridge fridgeNew){
        Fridge fridgeOld = fridgeRepository.getFridgeById(id);
        fridgeOld.setName(fridgeNew.getName());
        fridgeOld.setIsFreezer(fridgeNew.getIsFreezer());
        fridgeRepository.save(fridgeOld);
    }
}
