package com.cydeo.controller;


import com.cydeo.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    private final ProjectService projectService;

    public ManagerController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/status")
    public String projectStatus(Model model){

        model.addAttribute("projects", projectService.findAll());
        return "/manager/project-status";
    }
}
