package com.nardy.app.persistence.session;

import com.nardy.app.persistence.user.Users;
import com.nardy.app.persistence.user.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;

public class JdbcSessionRepository implements SessionRepository {

    private JdbcTemplate jdbc;
    private UsersRepository users;

    @Autowired
    public JdbcSessionRepository(JdbcTemplate jdbc, UsersRepository users){
        this.jdbc=jdbc;
        this.users=users;
    }

    @Override
    public Iterable<Session> findAll() {

    }

    @Override
    public Session findById(long id) {
        return null;
    }

    @Override
    public Session save(Session session) {

        }


    private Session mapRowToSession(ResultSet resultSet, int rowNumber)
        throws SQLException {
        return new Session  (users.findByLogin(resultSet.getString("playerOne")),
                users.findByLogin(resultSet.getString("playerTwo")),
                resultSet.getDate("createdAt"),
                resultSet.getLong("boardId"));
    }
}
