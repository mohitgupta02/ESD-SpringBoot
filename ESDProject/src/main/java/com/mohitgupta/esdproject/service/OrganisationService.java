package com.mohitgupta.esdproject.service;

import com.mohitgupta.esdproject.entity.Organisation;
import com.mohitgupta.esdproject.repository.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganisationService {

    @Autowired
    private OrganisationRepository organisationRepository;


    public List<Organisation> getAllOrg() {
        return organisationRepository.findAll();
    }

    public Optional<Organisation> getPlaceById(Long id) {
        return organisationRepository.findById(id);
    }

    public Organisation createOrg(Organisation newOrganisation) {
        return organisationRepository.save(newOrganisation);
    }
}
