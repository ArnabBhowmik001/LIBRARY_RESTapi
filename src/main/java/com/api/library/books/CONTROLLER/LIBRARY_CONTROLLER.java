package com.api.library.books.CONTROLLER;

import ch.qos.logback.classic.net.SimpleSocketServer;
import com.api.library.books.MODEL.Book;
import com.api.library.books.TEMPOBOOKSERVICE.BOOKSERVICE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LIBRARY_CONTROLLER {
    @Autowired
    @Qualifier("api")

    BOOKSERVICE bookservice;

    @GetMapping("/library")
    public ResponseEntity<List<Book>> getLibrary() {

            List<Book> abhi = bookservice.Getallbooks();
            if(abhi.size()<=0){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
            return ResponseEntity.status(HttpStatus.OK).body(abhi);
    }

    @GetMapping("/library/{id}")
    public Book getbyid(@PathVariable("id") int id) {
        Book book = new Book();
        book = bookservice.getbyid(id);
        return book;
    }

    @PostMapping("/library")
    public ResponseEntity<Book> addbook(@RequestBody Book b) {
      try{  Book bk = bookservice.addbook(b);
        System.out.println(bk);
        return ResponseEntity.status(HttpStatus.CREATED).build();}
      catch(Exception e){
          System.out.println(e);
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }

    }

    @PutMapping("/library/{id}")
    public Book updatelibrary(@PathVariable("id") int id,@RequestBody Book b)
    {
        Book d=bookservice.bookupdate(id,b);
        return d;

    }
    @DeleteMapping("/library/{id}")
    public void deletebook(@PathVariable("id") int id) {
        bookservice.deletebook(id);
    }


}



