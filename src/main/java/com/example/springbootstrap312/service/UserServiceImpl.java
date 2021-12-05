package com.example.springbootstrap312.service;

import com.example.springbootstrap312.dao.UserDAO;
import com.example.springbootstrap312.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    private BCryptPasswordEncoder bCrypt() {
        return new BCryptPasswordEncoder();
    }

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUser(long id) {
        return userDAO.getUser(id);
    }

    @Override
    public void addUser(User user) {
        user.setPassword(bCrypt().encode(user.getPassword()));
        userDAO.addUser(user);
    }

    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public void removeUser(long id) {
        userDAO.removeUser(id);
    }

    @Override
    public void updateUser(long id, User updatedUser) {
        userDAO.updateUser(id, updatedUser);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }
}
