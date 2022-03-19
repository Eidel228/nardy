package com.nardy.app.persistence.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Data
@AllArgsConstructor
public class Users {

    @NotNull
    @Size(min = 3,max = 32)
    private final String login;

    @NotNull
    @Size(min=3,max = 32)
    private final String password;

    @NotNull
    private final Date createdAt;

    @NotNull
    private double rating;

    private long session;

}


