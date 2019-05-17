package app.controller;

import app.entity.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("loggedUser")
public class TaskController {
//    @Autowired
//    private TaskRepository taskRepository;

    @PostMapping("/task")
    public String task(Model model) {
        return "task";
    }

    @PostMapping("/task_add")
    public String taskAdd(Model model) {
        Task task = new Task();
        model.addAttribute(task);
        return "task";
    }

    @PostMapping("/task_save")
    public String taskSave(@ModelAttribute("task") Task task, Model model) {
        // save task
        return "main";
    }

    @PostMapping("/task_del")
    public String taskDel(@ModelAttribute("task") Task task, Model model) {
        // del task
        return "main";
    }
}