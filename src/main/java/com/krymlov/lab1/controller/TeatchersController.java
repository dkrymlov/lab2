package com.krymlov.lab1.controller;

import com.krymlov.lab1.repository.TeatcherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeatchersController {

    @Autowired
    TeatcherRepo teatcherRepo;

    @GetMapping("/teatchers")
    public String getTeatchers(Model model){

        model.addAttribute("teatchers", teatcherRepo.findAll());

        return "/teatchers/teatchers";
    }

}
