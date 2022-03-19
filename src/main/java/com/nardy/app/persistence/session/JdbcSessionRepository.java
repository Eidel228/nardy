package com.nardy.app.persistence.session;

import com.nardy.app.persistence.user.Users;

public interface JdbcSessionRepository  {
    Users findByUserId(String User);
    Users save(Users user);
}
