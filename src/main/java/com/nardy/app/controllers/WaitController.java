package com.nardy.app.controllers;

import com.nardy.app.entity.Session;
import com.nardy.app.entity.User;
import com.nardy.app.entity.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/wait")
public class WaitController {

    private MatchRepository sessionRepo;

    private BoardRepository boardRepo;

    private User playerOne;

    private User playerTwo;

    long id;



    @Autowired
    public WaitController(MatchRepository sessionRepo, BoardRepository boardRepo ){
        this.sessionRepo=sessionRepo;
        this.boardRepo=boardRepo;
    }

    @GetMapping
    public String joinGame(@AuthenticationPrincipal User user){
        if(playerOne==null){
            playerOne=user;
            return "wait";
        }
        else {
            playerTwo=user;
            this.id = sessionRepo.save(new Session(playerOne, playerTwo)).getId();
            return "redirect:/game/"+id;
        }
    }

    @PostMapping
    public String refresh(){
        if(playerTwo==null){
            return "wait";
        }
        else return "redirect:/game/"+id;
    }
}
