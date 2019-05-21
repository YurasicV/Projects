package app.controller;

import app.entity.Action;
import app.entity.Task;
import app.entity.User;
import app.service.ActionService;
import app.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("loggedUser")
public class TaskController {
    private TaskService taskService;
    private ActionService actionService;

    public TaskController(TaskService taskService, ActionService actionService) {
        this.taskService = taskService;
        this.actionService = actionService;
    }

    @RequestMapping("/task/{id}")
    public String task(@PathVariable("id") Long id,
                       @SessionAttribute("loggedUser") User loggedUser,
                       Model model) {
        Optional<Task> currentTaskOptional = taskService.findById(id);
        if (!currentTaskOptional.isPresent()) {
            return "redirect:/main";
        }
        Task task = currentTaskOptional.get();
        task.setEditable(taskService.IsTaskEditable(task, loggedUser));
        model.addAttribute("currentTask", task);
        model.addAttribute("actionList", actionService.getActionList(task, loggedUser));
        return "task";
    }

    @PostMapping("/task/add")
    public String taskAdd(@SessionAttribute("loggedUser") User loggedUser, Model model) {
        Task currentTask = new Task();
        currentTask.setAuthor(loggedUser);
        model.addAttribute("currentTask", currentTask);
        model.addAttribute("actionList", actionService.getActionList(currentTask, loggedUser));
        return "task";
    }

    @PostMapping("/task/save")
    public String taskSave(@ModelAttribute("currentTask") Task currentTask,
                           @ModelAttribute("actionName") String actionName,
                           @SessionAttribute("loggedUser") User loggedUser,
                           Model model) {
        Action action = Action.valueOf(actionName);
        actionService.doAction(currentTask, loggedUser, action);
        if (action == Action.SAVE) {
            return "redirect:/task/" + currentTask.getId();
        }
        return "redirect:/main";
    }

    @PostMapping("/task/del/{id}")
    public String taskDel(@PathVariable("id") Long id,
                          Model model) {
        taskService.deleteById(id);
        return "redirect:/main";
    }
}