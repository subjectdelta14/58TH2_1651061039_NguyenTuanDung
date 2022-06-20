package com.example.demo.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DB_NEWS implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String desnews;
    private String linknews;
    private byte[] img;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    public DB_NEWS(){
        id=0;
    }

    public DB_NEWS(String desnews, String linknews, byte[] img, long id) {
        this.desnews = desnews;
        this.linknews = linknews;
        this.img = img;
        this.id = id;
    }

    public String getDesnews() {
        return desnews;
    }

    public void setDesnews(String desnews) {
        this.desnews = desnews;
    }

    public String getLinknews() {
        return linknews;
    }

    public void setLinknews(String linknews) {
        this.linknews = linknews;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}