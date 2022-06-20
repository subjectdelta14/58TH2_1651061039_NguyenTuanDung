package com.example.demo.api;



import java.util.List;

import javax.validation.Valid;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.DB_CUSTOMER;

import com.example.demo.service.ContactCustomer;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class RestApiCustomer {
    public static Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    ContactCustomer contactCustomer;

    @RequestMapping(value = "/qlvl/customer/get/", method = RequestMethod.GET)
    public ResponseEntity<List<DB_CUSTOMER>> listAllNews() {
        List<DB_CUSTOMER> listAcc = contactCustomer.findAll();
        if (listAcc.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<DB_CUSTOMER>>(listAcc, HttpStatus.OK);
    }

    @RequestMapping(value = "/qlvl/customer/get/{ID}", method = RequestMethod.GET)
    public DB_CUSTOMER findNews(@PathVariable("ID") long ID) {
        DB_CUSTOMER db_news = contactCustomer.getOne(ID);
        if (db_news == null) {
            ResponseEntity.notFound().build();
        }
        return db_news;
    }

    @RequestMapping(value = "/qlvl/customer/create/", method = RequestMethod.POST)
    public DB_CUSTOMER saveNews(@Valid @RequestBody DB_CUSTOMER db_news) {
        return contactCustomer.save(db_news);
    }

    @RequestMapping(value = "/qlvl/customer/updates/{id}", method = RequestMethod.POST)
    public ResponseEntity<DB_CUSTOMER> updateNews(@PathVariable(value = "id") Long contactId,
                                                 @Valid @RequestBody DB_CUSTOMER contactForm) {
        DB_CUSTOMER db_news = contactCustomer.getOne(contactId);
        if (db_news == null) {
            return ResponseEntity.notFound().build();
        }
        db_news.setName(contactForm.getName());
        db_news.setAdress(contactForm.getAdress());
        db_news.setEmail(contactForm.getEmail());
        db_news.setPhone(contactForm.getPhone());


        DB_CUSTOMER updatedNews = contactCustomer.save(db_news);
        return ResponseEntity.ok(updatedNews);
    }

    @RequestMapping(value = "/qlvl/customer/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DB_CUSTOMER> deleteHire(@PathVariable(value = "id") Long id) {
        DB_CUSTOMER db_news = contactCustomer.getOne(id);
        if (db_news == null) {
            return ResponseEntity.notFound().build();
        }

        contactCustomer.delete(db_news);
        return ResponseEntity.ok().build();


        //

    }
}

