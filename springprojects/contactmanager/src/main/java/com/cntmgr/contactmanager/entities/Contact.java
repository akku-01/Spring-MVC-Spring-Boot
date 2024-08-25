package com.cntmgr.contactmanager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "Contact_id")
    private int id;

    private String name;
    private String lastname;
    private String phone;
    @Column(length = 100)
    private String description;
    private String work;
    @Column(unique = true)
    private String email;
    private String image_path;

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @ManyToOne
    User user = new User();

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Contact [id=" + id + ", name=" + name + ", lastname=" + lastname + ", phone=" + phone + ", description="
                + description + ", work=" + work + ", email=" + email + ", image_path=" + image_path + "]";
    }
    public String getWork() {
        return work;
    }
    public void setWork(String work) {
        this.work = work;
    }
    public Contact(int id, String name, String lastname, String phone, String description, String work, String email,
            String image_path) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.description = description;
        this.work = work;
        this.email = email;
        this.image_path = image_path;
    }

    public Contact(){

    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getImage_path() {
        return image_path;
    }
    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
    
}