package com.krymlov.lab1.controller;

import com.krymlov.lab1.model.Teatcher;
import com.krymlov.lab1.model.Timetable;
import com.krymlov.lab1.repository.TimetableRepo;
import com.krymlov.lab1.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class TimetablesController {

    @Autowired
    TimetableService timetableService;

    @GetMapping("/timetables")
    public String getTimetables(Model model){

        model.addAttribute("timetables", timetableService.getRepo().findAll());

        return "/timetables/timetables";
    }

    @PostMapping("/insert/timetable")
    public String insertTimetables(@Valid Timetable timetable, RedirectAttributes redirectAttributes){

        if (timetableService.insertValid(timetable) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else {
            redirectAttributes.addFlashAttribute("response", "Успішне додавання сутності" + "\n"
                    + timetable.getPara() + " " + timetable.getRoom() + " " + timetable.getGroup().getName() + " " +
                    timetable.getLesson().getName() + " " + timetable.getTeatcher().getName() + " " + timetable.getDay().getName());
            return "redirect:/response";
        }
    }

    @PostMapping("/update/timetable")
    public String updateTimetables(@Valid Timetable timetable, RedirectAttributes redirectAttributes){
        if (timetableService.updateValid(timetable) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішна зміна сутності" + "\n"
                    + timetable.getPara() + " " + timetable.getRoom() + " " + timetable.getGroup().getName() + " " +
                    timetable.getLesson().getName() + " " + timetable.getTeatcher().getName() + " " + timetable.getDay().getName());
            return "redirect:/response";
        }
    }

    @PostMapping("/delete/timetable")
    public String deleteTimetables(@Valid Timetable timetable, RedirectAttributes redirectAttributes){
        if (timetableService.deleteValid(timetable.getId()) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            timetableService.deleteValid(timetable.getId());
            redirectAttributes.addFlashAttribute("response", "Успішне видаення сутності" + " " + timetable.getId());
            return "redirect:/response";
        }
    }

}
