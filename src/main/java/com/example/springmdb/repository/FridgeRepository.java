package com.example.springmdb.repository;

import com.example.springmdb.model.Fridge;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FridgeRepository extends MongoRepository<Fridge, Long> {

    Fridge getFridgeById(Long id);

}
