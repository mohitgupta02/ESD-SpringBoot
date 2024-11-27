package com.mohitgupta.esdproject.service;

import com.mohitgupta.esdproject.entity.Specialisation;
import com.mohitgupta.esdproject.repository.SpecialisationRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class SpecService {

    private SpecialisationRepository specialisationRepository;
    public Specialisation createSpec(Specialisation newSpecialisation) {
        return specialisationRepository.save(newSpecialisation);
    }
}
