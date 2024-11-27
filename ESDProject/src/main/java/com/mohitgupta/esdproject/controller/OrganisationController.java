package com.mohitgupta.esdproject.controller;

import com.mohitgupta.esdproject.entity.Login;
import com.mohitgupta.esdproject.dto.LoginMessage;
import com.mohitgupta.esdproject.entity.Organisation;
import com.mohitgupta.esdproject.entity.Placement;
import com.mohitgupta.esdproject.repository.OrganisationRepository;
import com.mohitgupta.esdproject.service.LoginService;
import com.mohitgupta.esdproject.service.OrganisationService;
import com.mohitgupta.esdproject.service.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@SpringBootApplication
@RestController
@CrossOrigin("http://localhost:3000")
public class OrganisationController {

    @Autowired
    private OrganisationRepository organisationRepository;

    @Autowired
    private OrganisationService organisationService;

    @Autowired
    private PlacementService placementService;

    @Autowired
    private LoginService loginService;


    public OrganisationController(OrganisationService organisationService,LoginService loginService){
        this.organisationService=organisationService;
        this.loginService = loginService;
    }

    @GetMapping("/organisations")
    List<Organisation> question1(){
            return organisationRepository.findAll();
        }

    @GetMapping("/place/{id}")
    Optional<Organisation> question(@PathVariable Long id){
        return organisationRepository.findById(id);
    }

    @PostMapping("/organisation")
    Organisation newOrganisation(@RequestBody Organisation newOrganisation) {
        return organisationRepository.save(newOrganisation);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginEmployee(@RequestBody Login login){
        LoginMessage loginMessage = loginService.loginEmployee(login);
        return  ResponseEntity.ok(loginMessage);
    }

    @GetMapping("/place")
    List<Placement> data(){
        return placementService.data();
        }


}
