package com.api.book.bookapi.entities;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int id;

    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Author author;

    public Book() {
        super();
    }

    public Book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
