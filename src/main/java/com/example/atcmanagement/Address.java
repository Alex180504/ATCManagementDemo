package com.example.atcmanagement;

import jakarta.persistence.*;

@Entity
@Table(name = "adress")
public class Address {
    @Id
    @Column(name = "adress_id")
    private int id;

    @Column(name = "district")
    private String district;

    @Column(name = "street")
    private String street;

    @Column(name = "building")
    private String building;

    @Column(name = "flat")
    private String flat;

    @Column(name = "postcode")
    private String postcode;

    @OneToOne
    @JoinColumn(name = "phone_phone_id")
    private Phone phone;


    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
