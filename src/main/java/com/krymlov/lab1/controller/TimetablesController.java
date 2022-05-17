package com.krymlov.lab1.controller;

import com.krymlov.lab1.repository.LessonRepo;
import com.krymlov.lab1.repository.TimetableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimetablesController {

    @Autowired
    TimetableRepo timetableRepo;

    @GetMapping("/timetables")
    public String getTimetables(Model model){

        model.addAttribute("timetables", timetableRepo.findAll());

        return "/timetables/timetables";
    }

}
