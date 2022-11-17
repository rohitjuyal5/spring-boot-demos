package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    void saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    List<User> getUser();
}
