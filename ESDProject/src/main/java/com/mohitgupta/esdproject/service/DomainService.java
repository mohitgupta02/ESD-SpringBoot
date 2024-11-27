package com.mohitgupta.esdproject.service;

import com.mohitgupta.esdproject.entity.Domain;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mohitgupta.esdproject.repository.DomainRepository;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class DomainService {
    @Autowired
    private DomainRepository domainRepository;

    public Domain getDomain(Domain newDomain){
        return domainRepository.save(newDomain);
    }
}
