package com.cntmgr.contactmanager.controllers;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cntmgr.contactmanager.dao.ContactRepo;
import com.cntmgr.contactmanager.dao.UserRepo;
import com.cntmgr.contactmanager.entities.Contact;
import com.cntmgr.contactmanager.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepo userRepo ;

    @Autowired
    private ContactRepo contactRepo;

    @ModelAttribute
    public void common(Model m,Principal p){
        String username = p.getName();
        User u = userRepo.getUserByUserName(username);
        m.addAttribute("user", u);
    }

    @RequestMapping("/index")
    public String dashboard(Model m){
        m.addAttribute("title", "User Dashboard");
        return "normal/user_dashboard";
    }

    @RequestMapping("/add-contact")
    public String add_contact(Model m){
        m.addAttribute("title", "Add Contact");
        m.addAttribute("contact", new Contact());
        return "normal/add_contact";
    }

    @PostMapping("/process_add_contact")
    public String handler(@ModelAttribute Contact contact,Principal principal ,@RequestParam("profileimage") MultipartFile file,Model m){
        try{
        String u = principal.getName();
        User user = userRepo.getUserByUserName(u);

        if(!file.isEmpty()){
            contact.setImage_path(file.getOriginalFilename());
            File saveFile = new ClassPathResource("static/images").getFile();
            Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        }else{
            contact.setImage_path("blank.webp");
        }

        contact.setUser(user);

        user.getContacts().add(contact);
        userRepo.save(user);
        System.out.println(contact);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        m.addAttribute("check", 0);
        return "normal/add_contact";
    }

    //per page contacts = 5(let n)
    //no. of pages = page
    //current page = 0
    @RequestMapping("/show-contacts/{page}")
    public String handler2(@PathVariable("page") Integer page,Model m,Principal principal){
        String username = principal.getName();
        User user = userRepo.getUserByUserName(username);
        
        //(pageno.,entries per page)
        Pageable pageable = PageRequest.of(page,5);
        Page<Contact> contacts = contactRepo.getContactsByUser(user.getId(),pageable);
        m.addAttribute("contacts", contacts);
        m.addAttribute("title", "Your Contacts");
        m.addAttribute("currentpage", page);
        m.addAttribute("totalpages", contacts.getTotalPages());
        return "normal/show_contacts";
    }

    @RequestMapping("/{cid}/contact")
    public String handler3(@PathVariable("cid") Integer cid,Model model){
        Contact contact = contactRepo.getContactById(cid);
        model.addAttribute("contact", contact);
        return "normal/contact_detail";
    }
}

