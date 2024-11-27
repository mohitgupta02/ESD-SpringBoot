package com.mohitgupta.esdproject.repository;

import com.mohitgupta.esdproject.entity.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainRepository extends JpaRepository<Domain,Long> {
}
