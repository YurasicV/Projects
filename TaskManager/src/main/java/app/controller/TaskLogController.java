package app.controller;

import app.entity.Task;
import app.entity.TaskStatus;
import app.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskLogController {

    @PostMapping("/tasklog")
    public String task(Model model) {
        Task task = new Task(new User(), "my subject", "bla-bla-bla", TaskStatus.RUNNING);

        model.addAttribute(task);
        return "tasklog";
    }
}
