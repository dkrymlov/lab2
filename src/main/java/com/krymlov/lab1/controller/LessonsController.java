package com.krymlov.lab1.controller;

import com.krymlov.lab1.model.Lesson;
import com.krymlov.lab1.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class LessonsController {

    @Autowired
    LessonService lessonsService;

    @GetMapping("/lessons")
    public String getLessons(Model model){

        model.addAttribute("lessons", lessonsService.getRepo().findAll());

        return "/lessons/lessons";
    }

    @PostMapping("/insert/lesson")
    public String insertLessons(@Valid Lesson lesson, RedirectAttributes redirectAttributes){

        if (lessonsService.insertValid(lesson) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else {
            redirectAttributes.addFlashAttribute("response", "Успішне додавання сутності" + "\n"
                    + lesson.getName() + " " + lesson.getHours() + " " + lesson.getType().getName() + " " + lesson.getControl());
            return "redirect:/response";
        }
    }

    @PostMapping("/update/lesson")
    public String updateLessons(@Valid Lesson lesson, RedirectAttributes redirectAttributes){
        if (lessonsService.updateValid(lesson) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішна зміна сутності" + "\n"
                    + lesson.getName() + " " + lesson.getHours() + " " + lesson.getType().getName() + " " + lesson.getControl());
            return "redirect:/response";
        }
    }

    @PostMapping("/delete/lesson")
    public String deleteLessons(@Valid Lesson lesson, RedirectAttributes redirectAttributes){
        if (lessonsService.deleteValid(lesson.getId()) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            lessonsService.deleteValid(lesson.getId());
            redirectAttributes.addFlashAttribute("response", "Успішне видаення сутності" + " " + lesson.getId());
            return "redirect:/response";
        }
    }
}
