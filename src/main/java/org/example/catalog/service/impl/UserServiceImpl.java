package org.example.catalog.service.impl;

import org.example.catalog.model.User;
import org.example.catalog.repository.UserRepository;
import org.example.catalog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void create(User user) {
        userRepository.create(user);
    }

    @Override
    @Transactional
    public void edit(User user) {
        userRepository.edit(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    @Transactional
    public List<User> allUsers() {
        return userRepository.allUsers();
    }

    @Override
    @Transactional
    public User getById(int id) {
        return userRepository.getById(id);
    }
}
