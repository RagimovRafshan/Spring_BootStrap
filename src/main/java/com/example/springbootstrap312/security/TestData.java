package com.example.springbootstrap312.security;

import com.example.springbootstrap312.model.Role;
import com.example.springbootstrap312.model.User;
import com.example.springbootstrap312.service.RoleService;
import com.example.springbootstrap312.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class TestData {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public TestData(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void insertData() {

//        Role roleAdmin = new Role("ROLE_ADMIN");
//        Role roleUser = new Role("ROLE_USER");
        roleService.saveRole(new Role("ROLE_ADMIN"));
        roleService.saveRole(new Role("ROLE_USER"));

        Set<Role> roles1 = new HashSet<>();
        roles1.add(roleService.getRoleByName("ROLE_USER"));

        User bob = new User();
        bob.setFirstName("Bob");
        bob.setPassword("bob");
        bob.setLastName("Dealan");
        bob.setAge(51);
        bob.setEmail("bobby513@test.com");
        bob.setRoles(roles1);
        userService.addUser(bob);

        Set<Role> roles2 = new HashSet<>();
        roles2.add(roleService.getRoleByName("ROLE_USER"));
        roles2.add(roleService.getRoleByName("ROLE_ADMIN"));

        User tom = new User();
        tom.setFirstName("Tom");
        tom.setPassword("tom");
        tom.setLastName("Sawyer");
        tom.setAge(32);
        tom.setEmail("tom32@test.com");
        tom.setRoles(roles2);
        userService.addUser(tom);
    }
}