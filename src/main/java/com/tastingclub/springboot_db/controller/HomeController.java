package com.tastingclub.springboot_db.controller;

import com.tastingclub.springboot_db.model.User;
import com.tastingclub.springboot_db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller

public class HomeController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String index(Model model){
        List<User> userList = userService.fetchAll();
        model.addAttribute("users", userList);
        return "index";
    }

    @GetMapping("/adduser")
    public String add_User(Model model){
        return "addUser";
    }

    @PostMapping("/addUSer")
    public String addUser(@ModelAttribute User user){
        return null;
    }

}
