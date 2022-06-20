package com.example.demo.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DB_HIRE implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private String email;
    private String position;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    public DB_HIRE(){
        id=0;
    }

    public DB_HIRE(String name, String email, String position, long id) {
        this.name = name;
        this.email = email;
        this.position = position;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}