package com.mohitgupta.esdproject.model;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@Entity
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organisation_id")
    private long OrganisationId;

    @Column(nullable = false)
    private String name;

    private String address;


    public long getOrganisationId() {
        return OrganisationId;
    }

    public void setOrganisationId(long organisationId) {
        OrganisationId = organisationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
