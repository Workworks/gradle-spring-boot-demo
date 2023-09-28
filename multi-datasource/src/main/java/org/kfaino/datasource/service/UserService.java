package org.kfaino.datasource.service;

import org.kfaino.datasource.annotation.DataSource;
import org.kfaino.datasource.entity.primary.User;
import org.kfaino.datasource.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @DataSource("primary")
    public User createUserInPrimary(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        return userRepository.save(user);
    }

    @DataSource("secondary")
    public User createUserInSecondary(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        return userRepository.save(user);
    }



    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
