package com.nardy.app.persistence.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcUsersRepository implements UsersRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcUsersRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Users> findAll() {
        return jdbc.query(
                "select login, password, createdAt, rating, session from Users",
                this::mapRowToUser);
    }

    @Override
    public Users findByLogin(String login) {
        return jdbc.queryForObject
                ("select login, password, createdAt, rating, session from Users where login=?",
                this::mapRowToUser, login);
    }

    @Override
    public Users save(Users user) {
        jdbc.update(
                "insert into Users (login, password, createdAt, rating, session) values (?, ?, ?, ?, ?)",
                user.getLogin(),
                user.getPassword(),
                user.getCreatedAt(),
                user.getRating(),
                user.getSession());
        return user;
    }

    private Users mapRowToUser(ResultSet resultSet, int rowNumber)
            throws SQLException {
        return new Users(resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getDate("createdAt"),
                        resultSet.getDouble("rating"),
                        resultSet.getLong("session"));
    }
}

