package com.dao.interfaces;

import com.model.User;

public interface UserDao extends Dao<User> {
    User getPersonByCredentials(final String email);
}
