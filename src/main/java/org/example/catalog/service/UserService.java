package org.example.catalog.service;

import org.example.catalog.model.User;

import java.util.List;

public interface UserService {
    void create(User user);

    void edit(User user);

    void delete(User user);

    List<User> allUsers();

    User getById(int id);
}
