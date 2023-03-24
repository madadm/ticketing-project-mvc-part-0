package com.cydeo.controller;


import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    private final ProjectService projectService;
    private final UserService userService;

    public ManagerController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/status")
    public String projectStatus(Model model){

        UserDTO manager = userService.findById("maria@cydeo.com");

        List<ProjectDTO> projects = projectService.getCountedListOfFinishedProjectDTO(manager);


        model.addAttribute("projects", projects);



        return "/manager/project-status";
    }
}
