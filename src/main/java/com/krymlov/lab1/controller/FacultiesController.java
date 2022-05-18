package com.krymlov.lab1.controller;

import com.krymlov.lab1.model.Faculty;
import com.krymlov.lab1.model.Lesson;
import com.krymlov.lab1.repository.FacultyRepo;
import com.krymlov.lab1.repository.LessonRepo;
import com.krymlov.lab1.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class FacultiesController {

    @Autowired
    FacultyService facultyService;

    @GetMapping("/faculties")
    public String getFaculties(Model model){

        model.addAttribute("faculties", facultyService.getRepo().findAll());

        return "/faculties/faculties";
    }

    @PostMapping("/insert/faculty")
    public String insertFaculties(@Valid Faculty faculty, RedirectAttributes redirectAttributes){

        if (facultyService.insertValid(faculty) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else {
            redirectAttributes.addFlashAttribute("response", "Успішне додавання сутності" + "\n" + faculty.getName());
            return "redirect:/response";
        }
    }

    @PostMapping("/update/faculty")
    public String updateFaculties(@Valid Faculty faculty, RedirectAttributes redirectAttributes){
        if (facultyService.updateValid(faculty) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішна зміна сутності" + "\n" + faculty.getName());
            return "redirect:/response";
        }
    }

    @PostMapping("/delete/faculty")
    public String deleteFaculties(@Valid Faculty faculty, RedirectAttributes redirectAttributes){
        if (facultyService.deleteValid(faculty.getId()) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            facultyService.deleteValid(faculty.getId());
            redirectAttributes.addFlashAttribute("response", "Успішне видаення сутності" + " " + faculty.getId());
            return "redirect:/response";
        }
    }


}
