package com.nardy.app.persistence.session;

import com.nardy.app.persistence.user.Users;

public interface SessionRepository {
    Iterable<Users> findAll();
    Users findById(long id);
    Users save(Users user);
}
