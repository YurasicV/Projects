package app.controller;

import app.entity.Role;
import app.entity.User;
import app.service.PasswordEncoderService;
import app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegisterController {
    private UserService userService;
    private PasswordEncoderService passwordEncoderService;

    public RegisterController(UserService userService,
                              PasswordEncoderService passwordEncoderService) {
        this.userService = userService;
        this.passwordEncoderService = passwordEncoderService;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        String userName = user.getUserName();
        User userDb = userService.findByUserName(userName);
        if (userDb != null) {
            model.addAttribute("message", "User " + userName + " already exists!");
            return "register";
        }
        user.setEnabled(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoderService.passwordEncoder().encode(user.getPassword()));
        userService.save(user);
        model.addAttribute("message", "User " + userName +
                " has been registered successfully! Please, login");
        return "login";
    }
}
