package com.nardy.app.entity;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

    private String username;
    private String password;

    public User toUser(PasswordEncoder passwordEncoder){
        return new User(
                username,
                passwordEncoder.encode(password),
                1500);
    }
}
