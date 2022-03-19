package com.nardy.app.persistence.user;

public interface UsersRepository {
    Iterable<Users> findAll();
    Users findByLogin(String login);
    Users save(Users user);
}
