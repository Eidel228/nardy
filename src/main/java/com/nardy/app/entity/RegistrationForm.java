package com.nardy.app.entity;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

    private String username;
    private String password;

    public Users toUser(PasswordEncoder passwordEncoder){
        return new Users(
                username,
                passwordEncoder.encode(password),
                1500);
    }
}
