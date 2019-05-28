package app.controller;

import app.entity.Task;
import app.entity.User;
import app.service.TaskService;
import app.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

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
    public String mainPageLogged(Principal principal,
                                 @PageableDefault(page=0, size=10) Pageable pageable,
                                 Model model) {
        User loggedUser = userService.findByUserName(principal.getName());

        Page<Task> tasks = taskService.findAllByUser(loggedUser, pageable);
        model.addAttribute("loggedUser", loggedUser);
        model.addAttribute("tasks", tasks);
        return "main";
    }

    @RequestMapping("/main")
    public String mainPage(@SessionAttribute("loggedUser") User loggedUser,
                           @PageableDefault(page=0, size=10) Pageable pageable,
                           Model model) {
        Page<Task> tasks = taskService.findAllByUser(loggedUser, pageable);
        model.addAttribute("loggedUser", loggedUser);
        model.addAttribute("tasks", tasks);
        return "main";
    }
}