package com.example.atcmanagement;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "subscriber")
public class Subscriber {
    @Id
    @Column(name = "subscriber_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "partronym")
    private String patronym;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "is_benefitiary", columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isBeneficiary;

    @ManyToOne
    @JoinColumn(name = "atc_idatc")
    private Atc atc;

    @Column(name = "intercity_enabled", columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean intercityEnabled;

    @Column(name = "is_enabled", columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isEnabled;

    @OneToOne(mappedBy = "subscriber", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Phone phone;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronym() {
        return patronym;
    }

    public void setPatronym(String patronym) {
        this.patronym = patronym;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getBeneficiary() {
        return isBeneficiary;
    }

    public void setBeneficiary(Boolean beneficiary) {
        isBeneficiary = beneficiary;
    }

    public Atc getAtc() {
        return atc;
    }

    public void setAtc(Atc atc) {
        this.atc = atc;
    }

    public Boolean getIntercityEnabled() {
        return intercityEnabled;
    }

    public void setIntercityEnabled(Boolean intercityEnabled) {
        this.intercityEnabled = intercityEnabled;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }
}
