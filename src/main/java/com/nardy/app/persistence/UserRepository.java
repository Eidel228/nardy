package com.nardy.app.persistence;

public interface UserRepository {
    Iterable<User> findAll();
    User findById(long id);
    User save(User user);
}
