package com.mohitgupta.esdproject.controller;

import com.mohitgupta.esdproject.entity.Placement;
import com.mohitgupta.esdproject.repository.PlacementRepository;
import com.mohitgupta.esdproject.service.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class PlacementController {

    @Autowired
    private PlacementRepository placementRepository;
    @Autowired
    private PlacementService placementService;

    @PostMapping("/placement")
    Placement newPlacement(@RequestBody Placement newPlacement){
        return placementService.createNewPlacement(newPlacement);
    }

    @GetMapping("/psend/{id}")
    Optional<Placement> setplacedata(@PathVariable Long id){
        return placementService.findPlacementById(id);
    }
}
