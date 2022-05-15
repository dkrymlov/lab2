package com.krymlov.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/homepage")
    public String homepage(Model model){
        return "Hello!";
    }

}
