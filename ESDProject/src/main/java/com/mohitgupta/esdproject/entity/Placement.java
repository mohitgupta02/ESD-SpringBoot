package com.mohitgupta.esdproject.model;

import jakarta.persistence.*;

@Entity
public class Placement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "placement_id")
    private long placementid;

    @Column(nullable = false)
    private String profile;

    private String description;
    @Column(nullable = false)
    private long intake;

    private Float min_grade;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_placement")
//    private List<Student> student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_org_id")
    private Organisation organisation;

    public long getPlacementid() {
        return placementid;
    }

    public void setPlacementid(long placementid) {
        this.placementid = placementid;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getIntake() {
        return intake;
    }

    public void setIntake(long intake) {
        this.intake = intake;
    }

    public Float getMin_grade() {
        return min_grade;
    }

    public void setMin_grade(Float min_grade) {
        this.min_grade = min_grade;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }
}
