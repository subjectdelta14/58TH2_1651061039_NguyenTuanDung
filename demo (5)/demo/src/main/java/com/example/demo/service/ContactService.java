package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DB_VL;


@Repository
public interface ContactService extends JpaRepository<DB_VL, Long>{
    //todo
}
