package com.mohitgupta.esdproject.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Specialisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialisation_id")
    private long specialisationId;

    @Column(nullable = false, unique = true)
    private long code;

    @Column(nullable = false)
    private String name;
    private String description;

    @Column(nullable = false)
    private long year;

    @Column(nullable = false)
    private long credits_required;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_specialisation" , referencedColumnName ="specialisation_id")
//    private List<Student> student;


    public long getSpecialisationId() {
        return specialisationId;
    }

    public void setSpecialisationId(long specialisationId) {
        this.specialisationId = specialisationId;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public long getCredits_required() {
        return credits_required;
    }

    public void setCredits_required(long credits_required) {
        this.credits_required = credits_required;
    }
}
