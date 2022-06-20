package com.example.demo.api;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import com.example.demo.model.DB_VL;
import com.example.demo.service.ContactService;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class RestApiController {
    public static Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    ContactService contactService;



    @RequestMapping(value = "/qlvl/", method = RequestMethod.GET)
    public ResponseEntity<List<DB_VL>> listAllContact(){

        List<DB_VL> listContact= contactService.findAll();

        if(listContact.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<DB_VL>>(listContact, HttpStatus.OK);
    }

    @RequestMapping(value = "/qlvl/{ID}", method = RequestMethod.GET)
    public DB_VL findContact(@PathVariable("ID") long ID) {
        DB_VL db_vl= contactService.getOne(ID);
        if(db_vl == null) {
            ResponseEntity.notFound().build();
        }
        return db_vl;
    }

    @RequestMapping(value = "/qlvl/", method = RequestMethod.POST)
    public  DB_VL saveContact(@Valid @RequestBody  DB_VL db_vl) {

        return contactService.save(db_vl);
    }

    @RequestMapping(value = "/qlvl/{ID}", method = RequestMethod.POST)

    public ResponseEntity<DB_VL> updateContact(@PathVariable(value = "ID") Long ID,
                                                 @Valid @RequestBody DB_VL contactForm) {
        DB_VL db_vl = contactService.getOne(ID);
        if(db_vl == null) {
            return ResponseEntity.notFound().build();
        }
        db_vl.setName(contactForm.getName());
        db_vl.setPrice(contactForm.getPrice());
        db_vl.setType(contactForm.getType());
        db_vl.setQuantity(contactForm.getQuantity());
        db_vl.setImg(contactForm.getImg());
        db_vl.setImpact(contactForm.getImpact());
        db_vl.setDescribepro(contactForm.getDescribepro());
        db_vl.setLocation(contactForm.getLocation());
        db_vl.setYear(contactForm.getYear());



        DB_VL updatedContact = contactService.save(db_vl);
        return ResponseEntity.ok(updatedContact);
    }

    @RequestMapping(value = "/qlvl/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DB_VL> deleteContact(@PathVariable(value = "id") Long id) {
        DB_VL db_vl = contactService.getOne(id);
        if(db_vl == null) {
            return ResponseEntity.notFound().build();
        }

        contactService.delete(db_vl);
        return ResponseEntity.ok().build();




    }


    //


}
