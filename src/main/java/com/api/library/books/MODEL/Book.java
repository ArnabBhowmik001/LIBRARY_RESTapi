package com.api.library.books.MODEL;





import javax.persistence.*;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int book_id;
    @Column(name = "book_name")
    private String book_name;

    @OneToOne(cascade = CascadeType.ALL)
    private Author book_author;
    public Author getBook_author() {
        return book_author;
    }

    public void setBook_author(Author book_author) {
        this.book_author = book_author;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }





    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", book_author='" + book_author + '\'' +
                '}';
    }
}


