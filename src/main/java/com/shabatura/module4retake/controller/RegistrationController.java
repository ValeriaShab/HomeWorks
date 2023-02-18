package com.shabatura.module4retake.controller;

import com.shabatura.module4retake.repository.UserRepository;
import com.shabatura.module4retake.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.shabatura.module4retake.dao.UserConvert.toDto;

@Controller
public class RegistrationController {
    private final UserRepository userRepository;

    @Autowired
    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        model.addAttribute("user", new UserDao());
        return "registration";
    }

    @PostMapping("process_registration")
    public String processRegister(@ModelAttribute UserDao user,
                                  @RequestParam String name,
                                  @RequestParam String surname,
                                  @RequestParam String email,
                                  @RequestParam String password) {
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        userRepository.save(toDto(user));
        return "redirect:/register-success";
    }

    @GetMapping("/register-success")
    public String getRegisterSuccessPage() {
        return "register_success";
    }
}
