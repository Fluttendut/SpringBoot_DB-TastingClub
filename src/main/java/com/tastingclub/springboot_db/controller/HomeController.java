package com.tastingclub.springboot_db.controller;

import com.tastingclub.springboot_db.model.User;
import com.tastingclub.springboot_db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/addUser")
    public String add(){
        return "/addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user){
        userService.addUser(user);
        return "redirect:/";
    }

    //model allows us to get the data from the HTML page and return it somewhere else
    @GetMapping("viewUser/{id}")
    public String viewUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.findUserByID(id));
        return "/viewUser";

    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        boolean deleted = userService.deleteUser(id);
        return "redirect:/";
    }

    //Use model
    @GetMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findUserByID(id));
        return "/editUser";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute User user){
        userService.updateUser(user.getUsrID(),user);
        return "redirect:/";
    }

}
