package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.impl.RoleServiceImpl;
import com.cydeo.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {


    private final RoleServiceImpl roleService;
    private final UserServiceImpl userService;

    public UserController(RoleServiceImpl roleService, UserServiceImpl userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String userCreate(Model model){

        model.addAttribute("user", new UserDTO());
        //                                           //find roles from DB
        model.addAttribute("listRoles", roleService.findAll());
        model.addAttribute("users", userService.findAll());
        return "/user/create";

    }
}
