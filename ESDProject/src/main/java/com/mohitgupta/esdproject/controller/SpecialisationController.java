package com.mohitgupta.esdproject.controller;

import com.mohitgupta.esdproject.entity.Specialisation;
import com.mohitgupta.esdproject.repository.SpecialisationRepository;
import com.mohitgupta.esdproject.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpecialisationController {

    @Autowired
    private SpecialisationRepository specialisationRepository;
    @Autowired
    private SpecService specSer;
    @PostMapping("/specialisation")
    Specialisation newSpecialisation(@RequestBody Specialisation newSpecialisation){
        return specSer.createSpec(newSpecialisation);
    }
}
