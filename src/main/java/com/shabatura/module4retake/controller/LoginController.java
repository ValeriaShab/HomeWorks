package com.shabatura.module4retake.controller;

import com.shabatura.module4retake.repository.UserRepository;
import com.shabatura.module4retake.dao.UserDao;
import com.shabatura.module4retake.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class LoginController {
    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public LoginController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        ;
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("user", new UserDao());
        return "login";
    }

    @PostMapping("process_login")
    public String processLogin(@ModelAttribute UserDao user,
                               @RequestParam String email,
                               @RequestParam String password) {
        List<UserDao> users = userService.getAllUsers();
        for (UserDao u : users) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                return "redirect:/list";
            }
        }
        return "redirect:/login-failed";
    }

    @GetMapping("/login-failed")
    public String getFailedLoginPage() {
        return "failed_login.html";
    }

    @GetMapping("/login/reset")
    public String getResetPasswordPage(Model model) {
        model.addAttribute("user", new UserDao());
        return "reset_password.html";
    }

    @PostMapping("/login/process_reset_password")
    public String resetPasswordProcess(@ModelAttribute UserDao user,
                                       @RequestParam String email,
                                       @RequestParam String password) {
        userRepository.updatePassword(password, email);
        return "redirect:/list";
    }
}
