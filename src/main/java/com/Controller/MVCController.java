package com.Controller;

import com.Model.User;
import com.Service.UserService;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MVCController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public String userList(Model model)
    {
        model.addAttribute("users", userService.readAll());
        return "Users";
    }
    @GetMapping("/{id}")
    public String userShow(@PathVariable Long id, Model model)
    {
        model.addAttribute("user", userService.read(id));
        return "User";
    }
    @GetMapping(value = "/registration")
    public String Add(Model model)
    {
        model.addAttribute("user", new User());
        return "Registration";
    }
    @GetMapping(value = "/login")
    public String Log(Model model)
    {
        //model.addAttribute("user", new User());
        return "Login";
    }
}
