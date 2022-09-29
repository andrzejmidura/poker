package pl.andrzejmidura.fivehanddrawpoker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homepage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("username", username);
        return "homepage";
    }
}
