package com.springboot.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Homecontroller {
    @RequestMapping("/")
    @ResponseBody //To show as it is text..
    public String handler(){
        return "akku";
    }

    @RequestMapping("home")
    public String handle(){
        System.out.println("home page is this one");
        return "home";
    }

    @RequestMapping("contact")
    public String handle3(){
        System.out.println("contact page is this one");
        return "contact";
    }
}
