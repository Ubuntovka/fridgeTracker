package com.example.springmdb.controller;

import com.example.springmdb.model.Fridge;
import com.example.springmdb.service.FridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/fridge")
public class FridgeRestController {

    @Autowired
    private FridgeService fridgeService;

    @GetMapping(value = "/")
    public List<Fridge> getAllFridges() {
        return fridgeService.getFridges();
    }

    @GetMapping(value = "/byId/{fridgeId}")
    public Fridge getFridgeById(@PathVariable("fridgeId") long fridgeId) {
        return fridgeService.getFridgeById(fridgeId);
    }

    @PostMapping(value = "/save")
    public Fridge saveFridge(@RequestBody Fridge fridge){
        return fridgeService.saveFridge(fridge);
    }


    @DeleteMapping(value = "/delete/{fridgeId}")
    public ResponseEntity<?> deleteFridgeById(@PathVariable long fridgeId) {
        fridgeService.deleteFridgeById(fridgeService.getFridgeById(fridgeId).getId());
        return new ResponseEntity<>("Fridge deleted successfully", HttpStatus.OK);
    }

}
