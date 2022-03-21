package com.nardy.app.persistence.board;

public interface BoardRepository {
    Iterable<Board> findAll();
    Board findBySessionId(long id);
    Board save(Board board);
}
