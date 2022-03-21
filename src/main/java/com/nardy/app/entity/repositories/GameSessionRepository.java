package com.nardy.app.entity.repositories;

import com.nardy.app.entity.GameSession;
import org.springframework.data.repository.CrudRepository;

public interface GameSessionRepository extends CrudRepository<GameSession, Long> {
    GameSession findById(long id);
}