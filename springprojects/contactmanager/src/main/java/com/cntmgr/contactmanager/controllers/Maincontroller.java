package com.cntmgr.contactmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cntmgr.contactmanager.dao.UserRepo;
import com.cntmgr.contactmanager.entities.User;
import com.cntmgr.contactmanager.helper.Message;


@Controller
public class Maincontroller {
    @Autowired
    private UserRepo userRepo;

    @RequestMapping("/")
    public String home(Model m){
        m.addAttribute("title", "Smart Contact Manager");
        return "home";
    }
    @RequestMapping("/about")
    public String about(Model m){
        m.addAttribute("title", "About Us");
        return "about";
    }
    @RequestMapping("/signup")
    public String signup(Model m){
        m.addAttribute("title", "Sign-Up");
        m.addAttribute("user", new User());
        return "signup";
    }
    @PostMapping("/registerit")
    public String registerit(@ModelAttribute("user") User user,@RequestParam(value = "check",defaultValue = "false") boolean check ,
    Model m){

        try{
            if (!check) {
                throw new Exception("You have not agreed with terms and conditions!");
            }
            System.out.println(user);
            System.out.println(check);
            System.out.println("1");
            m.addAttribute("message", new Message("Successfully registered!","alert-success" ));
            System.out.println("2");
            userRepo.save(user);
            return "signup";
        }catch(Exception e){
            e.printStackTrace();
            m.addAttribute("message", new Message("Something went wrong! "+e.getMessage(),"alert-danger" ));
            return "signup";
        }
        
        
    }
}
