package com.example.demo.api;

import java.util.List;

import javax.validation.Valid;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.DB_HIRE;

import com.example.demo.service.ContactHire;
@CrossOrigin()
@RestController
@RequestMapping("/api")
public class RestApiHire {
    public static Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    ContactHire contactHire;

    @RequestMapping(value = "/qlvl/hire/get/", method = RequestMethod.GET)
    public ResponseEntity<List<DB_HIRE>> listAllHire(){
        List<DB_HIRE> listNews= contactHire.findAll();
        if(listNews.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<DB_HIRE>>(listNews, HttpStatus.OK);
    }

    @RequestMapping(value = "/qlvl/hire/get/{ID}", method = RequestMethod.GET)
    public DB_HIRE findHire(@PathVariable("ID") long ID) {
        DB_HIRE db_hire= contactHire.getOne(ID);
        if(db_hire == null) {
            ResponseEntity.notFound().build();
        }
        return db_hire;
    }

    @RequestMapping(value = "/qlvl/hires/create/", method = RequestMethod.POST)
    public DB_HIRE saveHire(@Valid @RequestBody DB_HIRE db_hire) {
        return contactHire.save(db_hire);
    }

    @RequestMapping(value = "/qlvl/hire/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<DB_HIRE> updateAcc(@PathVariable(value = "id") Long contactId,
                                                @Valid @RequestBody DB_HIRE contactForm) {
        DB_HIRE db_acc = contactHire.getOne(contactId);
        if(db_acc == null) {
            return ResponseEntity.notFound().build();
        }
        db_acc.setName(contactForm.getName());
        db_acc.setEmail(contactForm.getEmail());
        db_acc.setPosition(contactForm.getPosition());


        DB_HIRE updatedContact = contactHire.save(db_acc);
        return ResponseEntity.ok(updatedContact);
    }

    @RequestMapping(value = "/qlvl/hire/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DB_HIRE> deleteHire(@PathVariable(value = "id") Long id) {
        DB_HIRE db_hire = contactHire.getOne(id);
        if(db_hire == null) {
            return ResponseEntity.notFound().build();
        }

        contactHire.delete(db_hire);
        return ResponseEntity.ok().build();



    }


    //

}

