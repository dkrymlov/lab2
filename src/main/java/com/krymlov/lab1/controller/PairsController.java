package com.krymlov.lab1.controller;

import com.krymlov.lab1.repository.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PairsController {

    @GetMapping("/pairs")
    public String getPairs(Model model){
        return "/pairs/pairs";
    }

}
