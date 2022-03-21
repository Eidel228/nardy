package com.nardy.app.auth;

import com.nardy.app.entity.Users;
import com.nardy.app.entity.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersRepositoryUserDetailsService implements UserDetailsService {

    private UsersRepository userRepo;

    @Autowired
    public UsersRepositoryUserDetailsService(UsersRepository userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);
        if(user!=null){
            return user;
        }
        throw new UsernameNotFoundException("User"+ username + "not found");
    }
}
