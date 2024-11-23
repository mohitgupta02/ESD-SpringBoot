package com.mohitgupta.esdproject.controller;

import com.mohitgupta.esdproject.model.Placement;
import com.mohitgupta.esdproject.repository.PlacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class PlacementController {

    @Autowired
    private PlacementRepository placementRepository;

    @PostMapping("/placement")
    Placement newPlacement(@RequestBody Placement newPlacement){
        return placementRepository.save(newPlacement);
    }

    @GetMapping("/psend/{id}")
    Optional<Placement> setplacedata(@PathVariable Long id){
        return placementRepository.findById(id);
    }
}
