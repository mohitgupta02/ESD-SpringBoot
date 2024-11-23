package com.mohitgupta.esdproject.controller;

import com.mohitgupta.esdproject.model.Specialisation;
import com.mohitgupta.esdproject.repository.SpecialisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpecialisationController {

    @Autowired
    private SpecialisationRepository specialisationRepository;

    @PostMapping("/specialisation")
    Specialisation newSpecialisation(@RequestBody Specialisation newSpecialisation){
        return specialisationRepository.save(newSpecialisation);
    }
}
