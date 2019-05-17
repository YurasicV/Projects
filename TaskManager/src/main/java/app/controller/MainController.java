package app.controller;

import app.entity.User;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@Controller
@SessionAttributes("loggedUser")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String mainPageLogged(Principal principal, Model model) {
//        User loggedUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User loggedUser = (User)principal;
        User loggedUser = userRepository.findByUserName(principal.getName());

        model.addAttribute("loggedUser", loggedUser);
        return "main";
    }

    @PostMapping("/main")
    public String mainPage(@ModelAttribute("loggedUser") User loggedUser, Model model) {
        model.addAttribute("loggedUser", loggedUser);
        return "main";
    }
}