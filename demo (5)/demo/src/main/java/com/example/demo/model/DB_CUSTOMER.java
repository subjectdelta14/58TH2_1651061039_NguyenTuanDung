package com.example.demo.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DB_CUSTOMER implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private String email;
    private String phone;
    private String adress;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    public DB_CUSTOMER(){
        id=0;
    }

    public DB_CUSTOMER(String name, String email, String phone, String adress, long id) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.adress = adress;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}