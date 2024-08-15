package com.api.book.bookapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bookapi.entities.Book;

// @Controller
@RestController //when we use rest controller then no need to add response body
public class BookController {
    // @ResponseBody
    // @RequestMapping(value = "/books",method = RequestMethod.GET)
    
    @GetMapping("/books")
    public Book handler(){
        Book b = new Book();
        b.setId(10);
        b.setAuthor("akku");
        b.setTitle("panchatantra ki kahaniya");
        return b;
    }
}
 