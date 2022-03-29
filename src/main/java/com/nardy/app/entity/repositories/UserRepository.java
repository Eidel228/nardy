package com.nardy.app.entity.repositories;

import com.nardy.app.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    User findByUsername(String username);
    @SuppressWarnings("unchecked")
    User save(User user);
}
