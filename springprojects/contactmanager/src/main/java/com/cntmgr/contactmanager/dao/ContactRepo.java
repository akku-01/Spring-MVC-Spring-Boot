package com.cntmgr.contactmanager.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
// import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cntmgr.contactmanager.entities.Contact;

public interface ContactRepo extends JpaRepository<Contact,Integer>{
    //pagination
    @Query("from Contact as c where c.user.id=:userId")
    public Page<Contact> getContactsByUser(@Param("userId")int userId, Pageable pageable);
    public Contact getContactById(int id);
}
