package com.nardy.app.controllers;

import com.nardy.app.entity.Session;
import com.nardy.app.entity.User;
import com.nardy.app.entity.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/game/{id}")
public class MatchController {

    private final MatchRepository sessionRepo;

    private final Session session;

        @Autowired
    public MatchController(@PathVariable long id, MatchRepository sessionRepo){
        this.sessionRepo=sessionRepo;
        this.session=sessionRepo.findById(id);
    }

    @GetMapping
    public String startGame(@AuthenticationPrincipal User user){
        if(!session.getPlayerTwo().equals(user)||!session.getPlayerOne().equals(user)){
            return "error";
        }
        else {
    }




}
