package com.service.interfaces;

import com.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    void add(final User person); // C

    User get(final int id); // R

    void update(final User person); // U

    void delete(final int id); // D

    User getPersonByCredentials(final String email);
}
