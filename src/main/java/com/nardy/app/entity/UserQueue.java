package com.nardy.app.entity;

import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

@Data
public class UserQueue  {

    private Users waitingUser;

    public boolean checkOpponent(){
        return waitingUser == null;
    }

    public Users lookForOpponent(Users user){
        if (waitingUser==null) {
            this.waitingUser=user;
            return null;
        }
        if(waitingUser==user){
            return null;
        }
        else {
            Users founded = waitingUser;
            waitingUser = null;
            return founded;
        }

    }

}
