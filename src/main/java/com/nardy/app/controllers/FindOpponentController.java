package com.nardy.app.controllers;

import com.nardy.app.entity.UserQueue;
import com.nardy.app.entity.Users;
import com.nardy.app.entity.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import java.security.Principal;

@Controller
@RequestMapping("/start")
public class FindOpponentController {

    private UsersRepository userRepo;

    private UserQueue queue;

    @Autowired
    public FindOpponentController(UserQueue queue){
        this.queue=queue;
    }

    @GetMapping
    public String showFindOpponentView(){
        return "/start";
    }
    @PostMapping
    public String findOpponent(SessionStatus status, @AuthenticationPrincipal Users user){
        Users opponent = queue.getWaitingUser();
        if (opponent==null||opponent.equals(user)) {
            return "/wait";
        }
        if(opponent==null||opponent==user)return "/wait";
        else return "/game";

    }

}
