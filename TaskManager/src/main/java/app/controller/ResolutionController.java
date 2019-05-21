package app.controller;

import app.entity.Instruction;
import app.entity.Resolution;
import app.entity.Task;
import app.service.ResolutionService;
import app.service.TaskService;
import app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class ResolutionController {
    private UserService userService;
    private TaskService taskService;
    private ResolutionService resolutionService;

    public ResolutionController(UserService userService, TaskService taskService,
                                ResolutionService resolutionService) {
        this.userService = userService;
        this.taskService = taskService;
        this.resolutionService = resolutionService;
    }

    @RequestMapping("/resolution/{id}")
    public String resolution(@PathVariable("id") Long id,
                             @ModelAttribute("taskId") Long taskId,
                             Model model) {
        Optional<Resolution> currentResolutionOptional = resolutionService.findById(id);
        if (!currentResolutionOptional.isPresent()) {
            return "redirect:/task/" + taskId;
        }
        model.addAttribute("resolution", currentResolutionOptional.get());
        model.addAttribute("users", userService.findAllByOrderByFullNameAsc());
        model.addAttribute("instructions", Instruction.values());
        return "resolution";
    }

    @PostMapping("/resolution/add")
    public String resolutionAdd(@ModelAttribute("taskId") Long taskId, Model model) {
        Resolution resolution = new Resolution();
        Optional<Task> currentTaskOptional = taskService.findById(taskId);
        if (!currentTaskOptional.isPresent()) {
            return "redirect:/main";
        }
        resolution.setTask(currentTaskOptional.get());
        model.addAttribute("resolution", resolution);
        model.addAttribute("users", userService.findAllByOrderByFullNameAsc());
        model.addAttribute("instructions", Instruction.values());
        return "resolution";
    }

    @PostMapping("/resolution/save")
    public String resolutionSave(@ModelAttribute("resolution") Resolution resolution,
                                 @ModelAttribute("taskId") Long taskId,
                                 Model model) {
        resolutionService.save(resolution);
        return "redirect:/task/" + taskId;
    }

    @PostMapping("/resolution/del/{id}")
    public String resolutionDel(@PathVariable("id") Long id,
                                @ModelAttribute("taskId") Long taskId,
                                Model model) {
        resolutionService.deleteById(id);
        return "redirect:/task/" + taskId;
    }
}
