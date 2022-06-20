package com.example.demo.service;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.DB_BILL;

@Repository
public interface ContactBill extends JpaRepository<DB_BILL, Long> {
//todo
}
