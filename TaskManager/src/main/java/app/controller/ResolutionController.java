package app.controller;

import app.entity.Instruction;
import app.entity.Resolution;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResolutionController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/resolution")
    public String resolution(@ModelAttribute("resolution") Resolution resolution, Model model) {
        model.addAttribute("users", userRepository.findAllByOrderByFullNameAsc());
        model.addAttribute("instructions", Instruction.values());
        return "resolution";
    }

    @PostMapping("/resolution_save")
    public String resolutionSave(@ModelAttribute("resolution") Resolution resolution, Model model) {
        // save resolution to task
        return "task";
    }

    @PostMapping("/resolution_del")
    public String resolutionDel(@ModelAttribute("resolution") Resolution resolution, Model model) {
        // del resolution from task
        return "task";
    }
}
