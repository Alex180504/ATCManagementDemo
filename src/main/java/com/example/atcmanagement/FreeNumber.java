package com.example.atcmanagement;

import jakarta.persistence.*;

@Entity
@Table(name = "free_number")
public class FreeNumber {
    @Id
    @Column(name = "number_id")
    private int id;

    @Column(name = "number")
    private String number;

    @ManyToOne
    @JoinColumn(name = "atc_idatc")
    private Atc atc;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Atc getAtc() {
        return atc;
    }

    public void setAtc(Atc atc) {
        this.atc = atc;
    }
}