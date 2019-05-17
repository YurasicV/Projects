package app.controller;

import app.config.PasswordEncoderConfig;
import app.entity.Role;
import app.entity.User;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegisterController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        String userName = user.getUserName();
        User userDb = userRepository.findByUserName(userName);
        if (userDb != null) {
            model.addAttribute("message", "User " + userName + " already exists!");
            return "register";
        }
        user.setEnabled(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(PasswordEncoderConfig.passwordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        model.addAttribute("message", "User " + userName +
                " has been registered successfully! Please, login");
        return "login";
    }
}
