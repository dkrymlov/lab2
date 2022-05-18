package com.krymlov.lab1.controller;

import com.krymlov.lab1.model.Lesson;
import com.krymlov.lab1.model.Teatcher;
import com.krymlov.lab1.repository.TeatcherRepo;
import com.krymlov.lab1.service.TeatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class TeatchersController {

    @Autowired
    TeatcherService teatcherService;

    @GetMapping("/teatchers")
    public String getTeatchers(Model model){

        model.addAttribute("teatchers", teatcherService.getRepo().findAll());

        return "/teatchers/teatchers";
    }

    @PostMapping("/insert/teatcher")
    public String insertTeatchers(@Valid Teatcher teatcher, RedirectAttributes redirectAttributes){

        if (teatcherService.insertValid(teatcher) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else {
            redirectAttributes.addFlashAttribute("response", "Успішне додавання сутності" + "\n"
                    + teatcher.getName() + " " + teatcher.getPhone() + " " + teatcher.getDegree());
            return "redirect:/response";
        }
    }

    @PostMapping("/update/teatcher")
    public String updateTeatchers(@Valid Teatcher teatcher, RedirectAttributes redirectAttributes){
        if (teatcherService.updateValid(teatcher) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішна зміна сутності" + "\n"
                    + teatcher.getName() + " " + teatcher.getPhone() + " " + teatcher.getDegree());
            return "redirect:/response";
        }
    }

    @PostMapping("/delete/teatcher")
    public String deleteTeatchers(@Valid Teatcher teatcher, RedirectAttributes redirectAttributes){
        if (teatcherService.deleteValid(teatcher.getId()) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            teatcherService.deleteValid(teatcher.getId());
            redirectAttributes.addFlashAttribute("response", "Успішне видаення сутності" + " " + teatcher.getId());
            return "redirect:/response";
        }
    }


}
