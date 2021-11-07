package com.zuikov.company.springboot_bootstrap.controller;


import com.zuikov.company.springboot_bootstrap.model.User;
import com.zuikov.company.springboot_bootstrap.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/user")
    public String userInfo(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
      //  model.addAttribute("roles", user.getRoles());
        return "user";
    }

}
