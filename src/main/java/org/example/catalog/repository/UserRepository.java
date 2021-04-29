package org.example.catalog.repository;

import org.example.catalog.model.User;

import java.util.List;

public interface UserRepository {
    void create(User user);

    void edit(User user);

    void delete(User user);

    List<User> allUsers();

    User getById(int id);
}
