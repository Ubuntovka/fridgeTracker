package com.example.springmdb.controller;

import com.example.springmdb.model.Fridge;
import com.example.springmdb.service.FridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

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

    @PutMapping(value = "/update/{fridgeId}")
    public ResponseEntity<?> updateFridge(@PathVariable long fridgeId, @RequestBody Fridge fridge){
        Fridge fridgeOld = fridgeService.getFridgeById(fridgeId);
        if(fridgeOld == null){
            return new ResponseEntity<>(
                    "Fridge not found",
                    HttpStatus.BAD_REQUEST
            );
        }

        fridgeService.updateFridge(fridgeId, fridge);

        return new ResponseEntity<>(
                "Fridge Successfully Updated",
                HttpStatus.OK
        );
    }

}
