package com.mohitgupta.academiaesd.controller;

import com.mohitgupta.academiaesd.model.Domain;
import com.mohitgupta.academiaesd.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DomainController {

    @Autowired
    private DomainRepository domainRepository;


    @PostMapping("/domain")
    Domain newDomain(@RequestBody Domain newDomain){
        return domainRepository.save(newDomain);
    }
}
