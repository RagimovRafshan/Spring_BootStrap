package com.example.springbootstrap312.service;

import com.example.springbootstrap312.dao.UserDAO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDAO userDAO;

    public UserDetailsServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails user =  userDAO.getUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User with e-mail: %s not found!", email));
        }
        return user;
    }
}
