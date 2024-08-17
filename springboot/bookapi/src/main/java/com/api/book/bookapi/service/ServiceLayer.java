package com.api.book.bookapi.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.bookapi.bookrepo.BookRepository;
import com.api.book.bookapi.entities.Book;

@Service
public class ServiceLayer {
    @Autowired
    private BookRepository bookRepository;
    // private static List<Book> lst = new ArrayList<>();

    // static{
    //     lst.add(new Book(11,"Akku ki kahani","Akku pehlwan"));
    //     lst.add(new Book(12,"Kahani","Pehlwan"));
    //     lst.add(new Book(13,"Akku ki Story","Boxer"));
    //     lst.add(new Book(14,"Jakkala","Dangi"));
    //     lst.add(new Book(15,"Mittipukadi","Kachra Seth"));
    // }
    

    public Iterable<Book> getBooks(){
        return this.bookRepository.findAll();
    }

    public Book getBook(int id){
        // Book b = new Book(); 
        // for (Book book : lst) {
        //     if (book.getId()==id) {
        //         return book;
        //     }
        // }
        // return null;
        return this.bookRepository.findById(id);
    }

    public void addBook(Book b){
        // lst.add(b);
        this.bookRepository.save(b);
    }

    public void deleteallbooks(){
        // lst.clear();
        this.bookRepository.deleteAll();
    }

    public void deleteBook(int id){
        // for (Book book : lst) {
        //     if (book.getId()==id) {
        //         lst.remove(book);
        //     }
        // }
        this.bookRepository.deleteById(id);
    }
}
