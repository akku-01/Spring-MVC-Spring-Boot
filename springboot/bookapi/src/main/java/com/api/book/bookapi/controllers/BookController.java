package com.api.book.bookapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bookapi.entities.Book;
import com.api.book.bookapi.service.ServiceLayer;

// @Controller
@RestController //when we use rest controller then no need to add response body
public class BookController {
    // @ResponseBody
    // @RequestMapping(value = "/books",method = RequestMethod.GET)
    
    @Autowired
    ServiceLayer serviceLayer = new ServiceLayer();

    @GetMapping("/books")
    public ResponseEntity<List<Book>> handler(){
        // Book b = new Book();
        // b.setId(10);
        // b.setAuthor("akku");
        // b.setTitle("panchatantra ki kahaniya");
        // return b;
        List<Book> lst= (List<Book>) this.serviceLayer.getBooks();
        // if (lst.==0) {
        //     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        // }
        return ResponseEntity.of(Optional.of(lst));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> handler2(@PathVariable("id") int id ){
        Book b =this.serviceLayer.getBook(id);
        if(b==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(b));
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addit(@RequestBody Book b){
        
        try{
            this.serviceLayer.addBook(b);
            return ResponseEntity.of(Optional.of(b));
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/books")
    public ResponseEntity<Void> deleteall(){
        
        try{
            this.serviceLayer.deleteallbooks();
            return ResponseEntity.ok().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id ){
        
        try{
            this.serviceLayer.deleteBook(id);
            return ResponseEntity.ok().build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/book/{id}")
    public String updateit(@PathVariable("id") int id ,@RequestBody Book b ){
        this.serviceLayer.deleteBook(id);
        this.serviceLayer.addBook(b);
        return "Updated book with id = "+id;
    }
}
 