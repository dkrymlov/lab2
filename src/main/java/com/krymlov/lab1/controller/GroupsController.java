package com.krymlov.lab1.controller;

import com.krymlov.lab1.model.Faculty;
import com.krymlov.lab1.model.Group;
import com.krymlov.lab1.repository.GroupRepo;
import com.krymlov.lab1.repository.LessonRepo;
import com.krymlov.lab1.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class GroupsController {

    @Autowired
    GroupService groupService;

    @GetMapping("/groups")
    public String getGroups(Model model){

        model.addAttribute("groups", groupService.getRepo().findAll());

        return "/groups/groups";
    }

    @PostMapping("/insert/group")
    public String insertGroups(@Valid Group group, RedirectAttributes redirectAttributes){

        if (groupService.insertValid(group) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else {
            redirectAttributes.addFlashAttribute("response", "Успішне додавання сутності" + "\n"
                    + group.getName() + " " + group.getCourse() + " " + group.getFaculty().getName() + " " + group.getStudents());
            return "redirect:/response";
        }
    }

    @PostMapping("/update/group")
    public String updateGroups(@Valid Group group, RedirectAttributes redirectAttributes){
        if (groupService.updateValid(group) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішна зміна сутності" + "\n"
                    + group.getName() + " " + group.getCourse() + " " + group.getFaculty().getName() + " " + group.getStudents());
            return "redirect:/response";
        }
    }

    @PostMapping("/delete/group")
    public String deleteGroups(@Valid Group group, RedirectAttributes redirectAttributes){
        if (groupService.deleteValid(group.getId()) == 1){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            groupService.deleteValid(group.getId());
            redirectAttributes.addFlashAttribute("response", "Успішне видаення сутності" + " " + group.getId());
            return "redirect:/response";
        }
    }

}
