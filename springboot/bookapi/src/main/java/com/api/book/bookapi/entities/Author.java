package com.api.book.bookapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {
    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Book b;

    public Book getB() {
        return b;
    }


    public void setB(Book b) {
        this.b = b;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private int authorId;
    private String f_name;
    private String l_name;

    
    public Author(int authorId, String f_name, String l_name) {
        this.authorId = authorId;
        this.f_name = f_name;
        this.l_name = l_name;
    }

    
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public Author(){
        super();
    }

    @Override
    public String toString() {
        return "Author [authorId=" + authorId + ", f_name=" + f_name + ", l_name=" + l_name + "]";
    }

}
