package com.mohitgupta.esdproject.service;

import com.mohitgupta.esdproject.model.Placement;
import com.mohitgupta.esdproject.repository.PlacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacementService {

    @Autowired
    private PlacementRepository placementRepository;

    public List<Placement> data(){return placementRepository.findAll();}

}
