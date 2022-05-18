package com.krymlov.lab1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {

    @GetMapping("/")
    public String redirect(){
        return "redirect:/timetables";
    }

    @GetMapping("/response")
    public String response(){
        return "security/return";
    }

}
