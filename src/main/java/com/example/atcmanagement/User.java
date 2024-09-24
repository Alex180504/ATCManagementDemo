package com.example.atcmanagement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "idKeys")
    private int idKeys;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "permissions")
    private String permissions;

    public int getIdKeys() {
        return idKeys;
    }

    public void setIdKeys(int idKeys) {
        this.idKeys = idKeys;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}