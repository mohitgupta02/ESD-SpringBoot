package com.mohitgupta.esdproject.controller;

import com.mohitgupta.esdproject.entity.Domain;
import com.mohitgupta.esdproject.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DomainController {

    @Autowired
    private DomainService domainService;


    @PostMapping("/domain")
    Domain newDomain(@RequestBody Domain newDomain){
        return domainService.getDomain(newDomain);
    }
}
