package com.example.demo.api;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.DB_VL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.DB_ACCOUNT;

import com.example.demo.service.ContactAccount;
@CrossOrigin()
@RestController
@RequestMapping("/api")
public class RestApiControllerAcc {
    public static Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    ContactAccount contactAccount;

    @RequestMapping(value = "/qlvl/acc/", method = RequestMethod.GET)
    public ResponseEntity<List<DB_ACCOUNT>> listAllAcc(){
        List<DB_ACCOUNT> listAcc= contactAccount.findAll();
        if(listAcc.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<DB_ACCOUNT>>(listAcc, HttpStatus.OK);
    }

    @RequestMapping(value = "/qlvl/acc/{ID}", method = RequestMethod.GET)
    public DB_ACCOUNT findAcc(@PathVariable("ID") long ID) {
        DB_ACCOUNT db_acc= contactAccount.getOne(ID);
        if(db_acc == null) {
            ResponseEntity.notFound().build();
        }
        return db_acc;
    }

    @RequestMapping(value = "/qlvl/acc/", method = RequestMethod.POST)
    public DB_ACCOUNT saveAcc(@Valid @RequestBody DB_ACCOUNT db_vl) {
        return contactAccount.save(db_vl);
    }

    @RequestMapping(value = "/qlvl/acc/{id}", method = RequestMethod.POST)
    public ResponseEntity<DB_ACCOUNT> updateAcc(@PathVariable(value = "id") Long contactId,
                                               @Valid @RequestBody DB_ACCOUNT contactForm) {
        DB_ACCOUNT db_acc = contactAccount.getOne(contactId);
        if(db_acc == null) {
            return ResponseEntity.notFound().build();
        }
        db_acc.setUsername(contactForm.getUsername());
        db_acc.setPassword(contactForm.getPassword());
        db_acc.setRole(contactForm.getRole());


        DB_ACCOUNT updatedContact = contactAccount.save(db_acc);
        return ResponseEntity.ok(updatedContact);
    }

    @RequestMapping(value = "/qlvl/acc/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DB_VL> deleteContact(@PathVariable(value = "id") Long id) {
        DB_ACCOUNT db_vl = contactAccount.getOne(id);
        if(db_vl == null) {
            return ResponseEntity.notFound().build();
        }

        contactAccount.delete(db_vl);
        return ResponseEntity.ok().build();




    }


    //

}
