package com.example.springbootstrap312.service;

import com.example.springbootstrap312.model.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface RoleService {

    List<Role> getAllRoles();

    Role getRoleById(long id);

    Role getRoleByName(String roleName);

    void saveRole(Role role);

    void updateRole(Role role);

    void removeRole(long id);

    HashSet<Role> getSetOfRoles(String[] roleSet);

    Set<Role> setRoleByName(String name, String[] rolesName);
}
