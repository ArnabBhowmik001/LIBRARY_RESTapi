package com.api.library.books.CONTROLLER;


import com.api.library.books.MODEL.Book;


import com.api.library.books.TEMPOBOOKSERVICE.BOOKSERVICE;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class LIBRARY_CONTROLLER {
    private final BOOKSERVICE bs;
    @Autowired
    public LIBRARY_CONTROLLER(BOOKSERVICE bs) {
        this.bs = bs;
    }


    @GetMapping("/library")
    public ResponseEntity<List<Book>> getLibrary() {

        List<Book> abhi = bs.Getallbooks();
        if (abhi.size() <= 0) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
        return ResponseEntity.status(HttpStatus.OK).body(abhi);
    }

    @GetMapping("/library/{id}")
    public ResponseEntity<Book> getbyid(@PathVariable("id") int id) {
        Book book = new Book();
        book = bs.getbyid(id);
        try {
            if (book == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
          return ResponseEntity.status(HttpStatus.OK).body(book);
    }



    @PostMapping("/library")
    public ResponseEntity<Book> addbook(@RequestBody Book b) {
      try{  Book bk = bs.addbook(b);
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
        Book d=bs.bookupdate(id,b);
        return d;

    }
    @DeleteMapping("/library/{id}")
    public void deletebook(@PathVariable("id") int id) {
        bs.deletebook(id);
    }
    @DeleteMapping("/library")
    public void delete(){
        bs.deleteall();
    }


}



