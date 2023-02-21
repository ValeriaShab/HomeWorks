package com.shabatura.module4retake.controller;

import com.shabatura.module4retake.dao.UserDao;
import com.shabatura.module4retake.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String userList(Model model) {
        List<UserDao> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
}
