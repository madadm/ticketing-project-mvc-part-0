package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
public class TaskController {


    private final UserService userService;
    private final ProjectService projectService;
    private final TaskService taskService;

    public TaskController(UserService userService, ProjectService projectService, TaskService taskService) {
        this.userService = userService;
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @GetMapping("/create")
    public String taskCreate(Model model) {

        model.addAttribute("task", new TaskDTO());
        model.addAttribute("employees", userService.findByRole("Employee"));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("tasks", taskService.findAll());


        return "/task/create";

    }

    @PostMapping("/create")
    public String taskSave(@ModelAttribute("task") TaskDTO task) {

        taskService.save(task);
        return "redirect:/task/create";
    }

    @GetMapping("/delete/{taskId}")
    public String taskDelete(@PathVariable("taskId") Long taskId) {
        taskService.deleteById(taskId);
        return "redirect:/task/create";
    }


    @GetMapping("/update/{taskId}")
    public String taskEdit(@PathVariable("taskId") Long taskId, Model model) {

        model.addAttribute("task", taskService.findById(taskId));
        model.addAttribute("employees", userService.findByRole("Employee"));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("tasks", taskService.findAll());

        return "/task/update";
    }

    //    @PostMapping("/update/{taskId}")                          Don't need to put ModelVariable here
//    public String updateTask(@PathVariable("taskId") Long taskId,  TaskDTO task){
//
//         task.setId(taskId);
//         taskService.update(task);
//        return "redirect:/task/create";
//    }
    @PostMapping("/update/{id}")
    public String updateTask( TaskDTO task) {

        taskService.update(task);
        return "redirect:/task/create";
    }

}

