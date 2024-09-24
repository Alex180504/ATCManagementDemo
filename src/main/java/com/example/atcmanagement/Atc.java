package com.example.atcmanagement;

import jakarta.persistence.*;

@Entity
@Table(name = "atc")
public class Atc {
    @Id
    @Column(name = "idatc")
    private int id;
    @Column(name = "atc_name")
    private String name;

    @Column(name = "atc_type")
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

