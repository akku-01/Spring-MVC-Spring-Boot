package com.example.demo.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymleafController {
    
    @GetMapping("/about")
    public String handler(Model model){
        model.addAttribute("name", "Shivansh");
        model.addAttribute("roll_no","21dcs011");
        Date d = new Date();
        model.addAttribute("date",d);
        return "about";
    }
}
