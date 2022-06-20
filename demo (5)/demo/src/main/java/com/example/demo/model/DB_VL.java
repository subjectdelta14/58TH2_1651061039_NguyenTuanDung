package com.example.demo.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DB_VL implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private String type;
    private String year;
    private String describepro;
    private String impact;
    private String location;
    private byte[] img;
    private int price;
    private int quantity;


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    public DB_VL(){

        id=0;
    }

    public DB_VL(String name, String type, String year, String describepro, String impact, String location, byte[] img, int price, int quantity, long id) {
        this.name = name;
        this.type = type;
        this.year = year;
        this.describepro = describepro;
        this.impact = impact;
        this.location = location;
        this.img = img;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;

    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescribepro() {
        return describepro;
    }

    public void setDescribepro(String describepro) {
        this.describepro = describepro;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Transient
    private String imageDecode;

}