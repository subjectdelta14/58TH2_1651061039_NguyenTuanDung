package com.example.demo.service;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.DB_CUSTOMER;

@Repository
public interface ContactCustomer extends JpaRepository<DB_CUSTOMER, Long> {
//todo
}