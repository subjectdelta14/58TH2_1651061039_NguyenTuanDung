package com.example.demo.api;



import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.DB_HIRE;
import com.example.demo.model.DB_VL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.DB_CONTACT;

import com.example.demo.service.ContactContact;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class RestApiContact {
    public static Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    ContactContact contactContact;

    @RequestMapping(value = "/qlvl/contact/get/", method = RequestMethod.GET)
    public ResponseEntity<List<DB_CONTACT>> listAllNews() {
        List<DB_CONTACT> listAcc = contactContact.findAll();
        if (listAcc.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<DB_CONTACT>>(listAcc, HttpStatus.OK);
    }

    @RequestMapping(value = "/qlvl/contact/get/{ID}", method = RequestMethod.GET)
    public DB_CONTACT findNews(@PathVariable("ID") long ID) {
        DB_CONTACT db_news = contactContact.getOne(ID);
        if (db_news == null) {
            ResponseEntity.notFound().build();
        }
        return db_news;
    }

    @RequestMapping(value = "/qlvl/contact/", method = RequestMethod.POST)
    public DB_CONTACT saveNews(@Valid @RequestBody DB_CONTACT db_news) {
        return contactContact.save(db_news);
    }

    @RequestMapping(value = "/qlvl/contacts/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<DB_CONTACT> updateNews(@PathVariable(value = "id") Long contactId,
                                              @Valid @RequestBody DB_CONTACT contactForm) {
        DB_CONTACT db_news = contactContact.getOne(contactId);
        if (db_news == null) {
            return ResponseEntity.notFound().build();
        }
        db_news.setName(contactForm.getName());
        db_news.setAdress(contactForm.getAdress());
        db_news.setEmail(contactForm.getEmail());
        db_news.setPhone(contactForm.getPhone());


        DB_CONTACT updatedNews = contactContact.save(db_news);
        return ResponseEntity.ok(updatedNews);
    }

    @RequestMapping(value = "/qlvl/contact/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DB_HIRE> deleteHire(@PathVariable(value = "id") Long id) {
        DB_CONTACT db_news = contactContact.getOne(id);
        if (db_news == null) {
            return ResponseEntity.notFound().build();
        }

        contactContact.delete(db_news);
        return ResponseEntity.ok().build();


        //

    }
}

