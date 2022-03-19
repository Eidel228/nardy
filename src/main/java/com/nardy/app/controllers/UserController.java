package com.nardy.app.controllers;

import com.nardy.app.persistence.user.Users;
import com.nardy.app.persistence.user.UsersRepository;
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
        private final UsersRepository userRepo;

        @Autowired
    public UserController(UsersRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public String showUserList(Model model) {
        List<Users> users = new ArrayList<>();
        userRepo.findAll().forEach(users::add);
        Users.Role[] roles = Users.Role.values();
        for (Users.Role role:roles){
        model.addAttribute(role.toString().toLowerCase(),)
    }
}
