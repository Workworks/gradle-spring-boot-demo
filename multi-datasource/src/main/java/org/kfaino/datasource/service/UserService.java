package org.kfaino.datasource.service;

import jakarta.annotation.Resource;
import org.kfaino.datasource.annotation.DataSource;
import org.kfaino.datasource.dto.UserDTO;
import org.kfaino.datasource.entity.primary.User;
import org.kfaino.datasource.repository.primary.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @DataSource()
    @Transactional("transactionManager")
    public User createUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        return userRepository.save(user);
    }
}
