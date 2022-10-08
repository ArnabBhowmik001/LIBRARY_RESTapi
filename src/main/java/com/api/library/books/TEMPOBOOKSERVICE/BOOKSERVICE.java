package com.api.library.books.TEMPOBOOKSERVICE;

import com.api.library.books.MODEL.Book;


import com.api.library.books.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;



@Component

public class BOOKSERVICE {
   private final BookRepository d;
    @Autowired
    public BOOKSERVICE(BookRepository d) {
        this.d = d;
    }

    //    private static List<Book> books = new ArrayList<>();
//    static{
//        books.add(new Book(1, "Java", "John"));
//      books.add(new Book(2, "C++", "John"));
//       books.add(new Book(3, "C#", "John"));
//    }
   public List<Book> Getallbooks(){
            return d.findAll();
   }
   public Book getbyid(int id){
        Book book= new Book();
     book= d.findById(id);

        return book;
   }
   public Book addbook(Book book ){
        d.save(book);
        return book;
   }
   public Book bookupdate(int id,Book b){

     Book h=d.findById(id);
        h.setBook_name(b.getBook_name());
        h.setBook_author(b.getBook_author());
        return h;

   }
public void deletebook(int id){
        //books.removeIf(x->x.getBook_id()==id);
        d.deleteById(id);
}
public void deleteall(){
        d.deleteAll();
}

}
