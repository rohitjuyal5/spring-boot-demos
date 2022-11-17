package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    public final UserService userService;

    @GetMapping("/users")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<List<User>> getStudents() {
        return ResponseEntity.ok().body(userService.getUser());
    }

    @PostMapping("/users")
    public ResponseEntity<?> saveUser(User user) {
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/roles")
    public ResponseEntity<?> saveRole(Role role) {
        userService.saveRole(role);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/users/add-role")
    public ResponseEntity<?> addRole(RoleForm roleForm) {
        userService.addRoleToUser(roleForm.getUsername(), roleForm.getRoleName());
        return ResponseEntity.ok().build();
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class RoleForm {
        private String username;
        private String roleName;
    }
}
