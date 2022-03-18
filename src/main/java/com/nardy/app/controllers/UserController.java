package com.nardy.app.controllers;

import com.nardy.app.persistence.User;
import com.nardy.app.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/createUser")
public class UserController {
        private final UserRepository userRepo;

        @Autowired
    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public String showUserList(Model model) {
        List<User> users = new ArrayList<>();
        userRepo.findAll().forEach(users::add);
        User.Role[] roles = User.Role.values();
        for (User.Role role:roles){
        model.addAttribute(role.toString().toLowerCase(),)
    }
}
