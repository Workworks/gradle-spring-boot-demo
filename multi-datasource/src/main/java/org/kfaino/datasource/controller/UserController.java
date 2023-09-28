package org.kfaino.datasource.controller;

import jakarta.annotation.Resource;
import org.kfaino.datasource.entity.primary.User;
import org.kfaino.datasource.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/primary")
    public User createUserInPrimary(@RequestParam String name, @RequestParam String email) {
        return userService.createUserInPrimary(name, email);
    }

    @PostMapping("/secondary")
    public User createUserInSecondary(@RequestParam String name, @RequestParam String email) {
        return userService.createUserInSecondary(name, email);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
