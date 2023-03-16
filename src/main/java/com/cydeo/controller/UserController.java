package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.impl.RoleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {


    RoleServiceImpl roleService;
    @GetMapping("/create")
    public String userCreate(Model model){

        model.addAttribute("user", new UserDTO());
        //                                           //find roles from DB
        model.addAttribute("listRoles", roleService.findAll());
        return "/user/create";

    }
}
