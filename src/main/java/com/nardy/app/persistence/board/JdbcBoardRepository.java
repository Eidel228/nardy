package com.nardy.app.persistence.board;

import com.nardy.app.persistence.session.Session;
import com.nardy.app.persistence.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcBoardRepository implements BoardRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcBoardRepository(JdbcTemplate jdbc){
        this.jdbc=jdbc;
    }

    @Override
    public Iterable<Board> findAll() {
        return null;
    }

    @Override
    public Board findBySessionId(long id) {
        return null;
    }

    @Override
    public Board save(Board board) {
        jdbc.update("insert into Board ()")
    }

    private Board mapRowToBoard(ResultSet resultSet, int rowNumber)
            throws SQLException {
        Board.Hole[] hole = new Board.Hole[24];
        for (int i = 1; i <= 25; i++){
            hole[i] = new Board.Hole(
                    resultSet
                        .getArray("holes")
                        .getResultSet()
                        .getInt(i),
                    resultSet
                        .getArray("isWhite")
                        .getResultSet()
                        .getBoolean(i));
        }
        return new Board(hole);
    }
}
