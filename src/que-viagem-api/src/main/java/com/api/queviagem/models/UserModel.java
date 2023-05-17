package com.api.queviagem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "package")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;
    @Column(nullable = false)
    private String email_user;
    @Column(nullable = false)
    private String password_user;
    @Column(nullable = false)
    private String type_user;
    @Column(nullable = false)
    private Boolean email_confirmed_user;

    public int getId_user() {
        return this.id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getEmail_user() {
        return this.email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getPassword_user() {
        return this.password_user;
    }

    public void setPassword_user(String password_user) {
        this.password_user = password_user;
    }

    public String getType_user() {
        return this.type_user;
    }

    public void setType_user(String type_user) {
        this.type_user = type_user;
    }

    public Boolean isEmail_confirmed_user() {
        return this.email_confirmed_user;
    }

    public Boolean getEmail_confirmed_user() {
        return this.email_confirmed_user;
    }

    public void setEmail_confirmed_user(Boolean email_confirmed_user) {
        this.email_confirmed_user = email_confirmed_user;
    }

}
