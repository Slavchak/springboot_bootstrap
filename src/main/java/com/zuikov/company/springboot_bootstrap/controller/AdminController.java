package com.zuikov.company.springboot_bootstrap.controller;

import com.zuikov.company.springboot_bootstrap.model.Role;
import com.zuikov.company.springboot_bootstrap.model.User;
import com.zuikov.company.springboot_bootstrap.service.RoleService;
import com.zuikov.company.springboot_bootstrap.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

//    @RequestMapping(value = "login", method = RequestMethod.GET)
//    public String loginPage() {
//        return "login";
//    }

    @GetMapping
    public String findAll(@AuthenticationPrincipal User user, Model model){
        List<User> users = userService.getAllUser();
        model.addAttribute("allUsers", users);
        model.addAttribute("allRoles", roleService.allRoles());
        model.addAttribute("currentUser", user);
        model.addAttribute("user", new User());
        return "admin";
    }

    @PostMapping("/new-user")
    public String saveUser (@ModelAttribute User user,
                            @RequestParam(value = "rolesBox") String[] rolesBox) {
        Set<Role> roleSet = new HashSet<>();
        if (rolesBox != null) {
            for (String roleName : rolesBox) {
                roleSet.add(roleService.findRoleByName(roleName));
            }
        }
        user.setRoles(roleSet);
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/{id}/delete")
    public String deleteUser (@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @PostMapping("/edit/{id}")
    public String updateUser (@ModelAttribute("user") User user,
                              @RequestParam(value = "editRoles") String[] editRoles) {
        Set<Role> roleSet = new HashSet<>();
        if (editRoles != null) {
            for (String roleName : editRoles) {
                roleSet.add(roleService.findRoleByName(roleName));
            }
        }
        user.setRoles(roleSet);
        userService.update(user);
        return "redirect:/admin";
    }
}
