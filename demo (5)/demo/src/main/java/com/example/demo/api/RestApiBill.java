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

import com.example.demo.model.DB_BILL;

import com.example.demo.service.ContactBill;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class RestApiBill {
    public static Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    ContactBill contactBill;

    @RequestMapping(value = "/qlvl/bill/get/", method = RequestMethod.GET)
    public ResponseEntity<List<DB_BILL>> listAllNews() {
        List<DB_BILL> listAcc = contactBill.findAll();
        if (listAcc.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<DB_BILL>>(listAcc, HttpStatus.OK);
    }

    @RequestMapping(value = "/qlvl/bill/get/{ID}", method = RequestMethod.GET)
    public DB_BILL findNews(@PathVariable("ID") long ID) {
        DB_BILL db_news = contactBill.getOne(ID);
        if (db_news == null) {
            ResponseEntity.notFound().build();
        }
        return db_news;
    }

    @RequestMapping(value = "/qlvl/bill/", method = RequestMethod.POST)
    public DB_BILL saveNews(@Valid @RequestBody DB_BILL db_news) {
        return contactBill.save(db_news);
    }

    @RequestMapping(value = "/qlvl/bills/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<DB_BILL> updateNews(@PathVariable(value = "id") Long contactId,
                                                 @Valid @RequestBody DB_BILL contactForm) {
        DB_BILL db_news = contactBill.getOne(contactId);
        if (db_news == null) {
            return ResponseEntity.notFound().build();
        }
        db_news.setName(contactForm.getName());
        db_news.setPrice(contactForm.getPrice());
        db_news.setQuantity(contactForm.getQuantity());



        DB_BILL updatedNews = contactBill.save(db_news);
        return ResponseEntity.ok(updatedNews);
    }

    @RequestMapping(value = "/qlvl/bill/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DB_HIRE> deleteHire(@PathVariable(value = "id") Long id) {
        DB_BILL db_news = contactBill.getOne(id);
        if (db_news == null) {
            return ResponseEntity.notFound().build();
        }

        contactBill.delete(db_news);
        return ResponseEntity.ok().build();


        //

    }
}

