package com.nardy.app.persistence.session;

public interface SessionRepository {
    Iterable<Session> findAll();
    Session findByUserOne(String id);
    Session findByUserTwo(String id);
    Session save(Session session);
}
