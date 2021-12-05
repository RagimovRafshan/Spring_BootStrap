package com.example.springbootstrap312.dao;

import com.example.springbootstrap312.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    User getUser(long id);

    void addUser(User user);

    void saveUser(User user);

    void removeUser(long id);

    void updateUser(long id, User updatedUser);

    User getUserByEmail(String email);
}