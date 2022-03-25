package com.nardy.app.controllers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import java.security.Principal;

@Controller
@RequestMapping("/wait")
public class WaitController {

    @GetMapping
    @Scheduled(initialDelay = 10000)
    public String checkOpponent(){
        return "/start";
    }
}
