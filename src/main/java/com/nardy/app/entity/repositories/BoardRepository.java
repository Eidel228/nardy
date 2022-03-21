package com.nardy.app.entity.repositories;

import com.nardy.app.entity.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
    Board findById(long id);
}
