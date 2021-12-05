package com.example.springbootstrap312.service;

import com.example.springbootstrap312.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(long id);

    public void addUser(User user);

    void saveUser(User user);

    void removeUser(long id);

    void updateUser(long id, User updatedUser);

    User getUserByEmail(String email);
}
