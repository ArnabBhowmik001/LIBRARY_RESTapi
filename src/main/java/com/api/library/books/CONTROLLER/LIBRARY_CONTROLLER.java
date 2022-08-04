package com.api.library.books.CONTROLLER;

import com.api.library.books.MODEL.Book;
import com.api.library.books.TEMPOBOOKSERVICE.BOOKSERVICE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LIBRARY_CONTROLLER {
    @Autowired
    @Qualifier("api")

    BOOKSERVICE bookservice;

    @GetMapping("/library")
    public List<Book> getLibrary() {

        return bookservice.Getallbooks();
    }

    @GetMapping("/library/{id}")
    public Book getbyid(@PathVariable("id") int id) {
        Book book = new Book();
        book = bookservice.getbyid(id);
        return book;
    }

    @PostMapping("/library")
    public Book addbook(@RequestBody Book b) {
        Book bk = bookservice.addbook(b);
        System.out.println(bk);
        return bk;

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



