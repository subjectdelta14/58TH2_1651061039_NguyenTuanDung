package com.example.demo.service;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.DB_ACCOUNT;

@Repository
public interface ContactAccount extends JpaRepository<DB_ACCOUNT, Long> {
//todo
}