package com.krymlov.lab1.controller;

import com.krymlov.lab1.repository.GroupRepo;
import com.krymlov.lab1.repository.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GroupsController {

    @Autowired
    GroupRepo groupRepo;

    @GetMapping("/groups")
    public String getGroups(Model model){

        model.addAttribute("groups", groupRepo.findAll());

        return "/groups/groups";
    }

}
