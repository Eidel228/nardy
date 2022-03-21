package com.nardy.app.entity.repositories;

import com.nardy.app.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, String> {
    Users findByUsername(String username);
}
