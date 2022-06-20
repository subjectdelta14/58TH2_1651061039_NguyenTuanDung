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

import com.example.demo.model.DB_NEWS;

import com.example.demo.service.ContactNews;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class RestApiNews {
    public static Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    ContactNews contactNews;

    @RequestMapping(value = "/qlvl/news/get/", method = RequestMethod.GET)
    public ResponseEntity<List<DB_NEWS>> listAllNews() {
        List<DB_NEWS> listAcc = contactNews.findAll();
        if (listAcc.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<DB_NEWS>>(listAcc, HttpStatus.OK);
    }

    @RequestMapping(value = "/qlvl/news/get/{ID}", method = RequestMethod.GET)
    public DB_NEWS findNews(@PathVariable("ID") long ID) {
        DB_NEWS db_news = contactNews.getOne(ID);
        if (db_news == null) {
            ResponseEntity.notFound().build();
        }
        return db_news;
    }

    @RequestMapping(value = "/qlvl/news/", method = RequestMethod.POST)
    public DB_NEWS saveNews(@Valid @RequestBody DB_NEWS db_news) {
        return contactNews.save(db_news);
    }

    @RequestMapping(value = "/qlvl/news/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<DB_NEWS> updateNews(@PathVariable(value = "id") Long contactId,
                                              @Valid @RequestBody DB_NEWS contactForm) {
        DB_NEWS db_news = contactNews.getOne(contactId);
        if (db_news == null) {
            return ResponseEntity.notFound().build();
        }
        db_news.setDesnews(contactForm.getDesnews());
        db_news.setLinknews(contactForm.getLinknews());
        db_news.setImg(contactForm.getImg());


        DB_NEWS updatedNews = contactNews.save(db_news);
        return ResponseEntity.ok(updatedNews);
    }

    @RequestMapping(value = "/qlvl/news/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DB_HIRE> deleteHire(@PathVariable(value = "id") Long id) {
        DB_NEWS db_news = contactNews.getOne(id);
        if (db_news == null) {
            return ResponseEntity.notFound().build();
        }

        contactNews.delete(db_news);
        return ResponseEntity.ok().build();


        //

    }
}
