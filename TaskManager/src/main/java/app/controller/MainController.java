package app.controller;

import app.entity.Task;
import app.entity.User;
import app.service.TaskService;
import app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@Controller
@SessionAttributes("loggedUser")
public class MainController {
    private UserService userService;
    private TaskService taskService;

    public MainController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String mainPageLogged(Principal principal, Model model) {
//        User loggedUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User loggedUser = (User)principal;
        User loggedUser = userService.findByUserName(principal.getName());

        List<Task> tasks = taskService.findAllByUser(loggedUser);
        model.addAttribute("loggedUser", loggedUser);
        model.addAttribute("tasks", tasks);
        return "main";
    }

    @RequestMapping("/main")
    public String mainPage(@SessionAttribute("loggedUser") User loggedUser, Model model) {
        List<Task> tasks = taskService.findAllByUser(loggedUser);
        model.addAttribute("loggedUser", loggedUser);
        model.addAttribute("tasks", tasks);
        return "main";
    }
}