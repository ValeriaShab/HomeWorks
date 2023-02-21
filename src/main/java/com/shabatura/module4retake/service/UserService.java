package com.shabatura.module4retake.service;

import com.shabatura.module4retake.repository.UserRepository;
import com.shabatura.module4retake.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDao> getAllUsers() {
        List<UserDao> users = new ArrayList<>();
        userRepository.findAll().forEach(it -> users.add(new UserDao(it.getId(), it.getName(), it.getSurname(),
                it.getEmail(), it.getPassword())));
        return users;
    }

}
