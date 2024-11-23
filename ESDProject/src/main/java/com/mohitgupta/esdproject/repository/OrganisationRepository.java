package com.mohitgupta.esdproject.repository;

import com.mohitgupta.esdproject.model.Organisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation,Long> {



    @Query("select p.organisation.address,o.name from Placement p join p.organisation o")
////    @Query("select o.organisation_id from org;")
    List<Object[]> getOrganisation(Integer input);

}
