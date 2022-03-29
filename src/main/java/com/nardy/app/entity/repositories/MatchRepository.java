package com.nardy.app.entity.repositories;

import com.nardy.app.entity.Session;
import com.nardy.app.entity.User;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends CrudRepository<Session, Long> {

    Session findById(long id);

    Session findGameSessionByPlayerOne(User user);

    Session findGameSessionByPlayerTwo(User user);

    @SuppressWarnings("unchecked")
    Session save(Session session);

    BeanPostProcessor

    long findGameSessionIdByPlayerOne(User user);

    long findGameSessionIdByPlayerTwo(User user);



}