package com.example.demo.service;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.DB_CONTACT;

@Repository
public interface ContactContact extends JpaRepository<DB_CONTACT, Long> {
//todo
}