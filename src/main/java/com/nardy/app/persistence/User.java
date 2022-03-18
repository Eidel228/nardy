package com.nardy.app.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Data
@AllArgsConstructor
public class User {
    @NotNull
    private final long id;
    @NotNull
    private final Date createdAt;
    @NotNull
    @Size(min=3,max = 32)
    private final String name;
    @NotNull
    private double rating;
    @NotNull
    private Role role;

    public enum Role{
        USER,ADMIN;
    }

}


