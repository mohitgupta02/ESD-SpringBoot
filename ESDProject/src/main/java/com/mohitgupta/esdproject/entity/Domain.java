package com.mohitgupta.esdproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "domain_id")
    private long domainID;

    @Column(nullable = false)
    private String program;

    @Column(nullable = false)
    private String batch;

    @Column(nullable = false)
    private long capacity;

    private String qualification;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_domain" , referencedColumnName = "domain_id")
//    private List<Student> student;


    public long getDomainID() {
        return domainID;
    }

    public void setDomainID(long domainID) {
        this.domainID = domainID;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
