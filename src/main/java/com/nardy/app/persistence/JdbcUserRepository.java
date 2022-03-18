package com.nardy.app.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcUserRepository implements UserRepository{

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcUserRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<User> findAll() {
        return jdbc.query(
                "select id, createdAt, name, rating, role from User",
                this::mapRowToUser);
    }

    @Override
    public User findById(long id) {
        return jdbc.queryForObject
                ("select id, createdAt, name, rating, role from User where id=?",
                this::mapRowToUser, id);
    }

    @Override
    public User save(User user) {
        jdbc.update(
                "insert into User (id , createdAt, name, rating, role) values (?, ?, ?, ?, ?)",
                user.getId(),
                user.getCreatedAt(),
                user.getName(),
                user.getRating(),
                user.getRole().toString());
        return user;
    }

    private User mapRowToUser(ResultSet resultSet, int rowNumber)
            throws SQLException {
        return new User(resultSet.getLong("id"),
                        resultSet.getDate("createdAt"),
                        resultSet.getString("name"),
                        resultSet.getDouble("rating"),
                        User.Role.valueOf(resultSet.getString("role")));
    }
}

