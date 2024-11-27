package com.mohitgupta.esdproject.service;

import com.mohitgupta.esdproject.entity.Placement;
import com.mohitgupta.esdproject.repository.PlacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlacementService {

    @Autowired
    private PlacementRepository placementRepository;

    public List<Placement> data(){
        return placementRepository.findAll();
    }

    public Placement createNewPlacement(Placement newPlacement) {
        return placementRepository.save(newPlacement);
    }

    public Optional<Placement> findPlacementById(Long id) {
        return placementRepository.findById(id);
    }
}
