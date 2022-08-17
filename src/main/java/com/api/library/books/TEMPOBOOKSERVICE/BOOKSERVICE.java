package com.api.library.books.TEMPOBOOKSERVICE;
import java.util.*;
import com.api.library.books.MODEL.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component("api")

public class BOOKSERVICE {
    private static List<Book> books = new ArrayList<>();
    static{
        books.add(new Book(1, "Java", "John"));
      books.add(new Book(2, "C++", "John"));
       books.add(new Book(3, "C#", "John"));
    }
   public List<Book> Getallbooks(){
            return books;
   }
   public Book getbyid(int id){
        Book book= new Book();
     book= books.stream().filter(x->x.getBook_id()==id).findFirst().get();

        return book;
   }
   public Book addbook(Book book ){
        books.add(book);
        return book;
   }
   public Book bookupdate(int id,Book b){

       books=books.stream().map(x->{
            if(x.getBook_id()==id){
                x.setBook_name(b.getBook_name());
                x.setBook_author(b.getBook_author());
            }
            return x;
        }).collect(Collectors.toList());
       return b;

   }
public void deletebook(int id){
        //books.removeIf(x->x.getBook_id()==id);
       books=books.stream().filter(x->x.getBook_id()!=id).collect(Collectors.toList());
}

}
