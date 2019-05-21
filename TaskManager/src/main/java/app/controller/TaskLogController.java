package app.controller;

import app.entity.*;
import app.service.TaskLogService;
import app.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class TaskLogController {
    private TaskLogService taskLogService;
    private TaskService taskService;

    public TaskLogController(TaskLogService taskLogService, TaskService taskService) {
        this.taskLogService = taskLogService;
        this.taskService = taskService;
    }

    @RequestMapping("/tasklog/{id}")
    public String resolution(@PathVariable("id") Long id,
                             Model model) {
        Optional<Task> currentTaskOptional = taskService.findById(id);
        if (!currentTaskOptional.isPresent()) {
            return "redirect:/main";
        }
        model.addAttribute("currentTask", currentTaskOptional.get());
        model.addAttribute("tasklogs", taskLogService.findAllByTaskId(id));
        return "tasklog";
    }
}
