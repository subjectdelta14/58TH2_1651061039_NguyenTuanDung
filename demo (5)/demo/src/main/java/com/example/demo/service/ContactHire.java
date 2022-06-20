package com.example.demo.service;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.DB_HIRE;

@Repository
public interface ContactHire extends JpaRepository<DB_HIRE, Long> {
//todo
}