package pl.andrzejmidura.fivehanddrawpoker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.andrzejmidura.fivehanddrawpoker.entity.User;
import pl.andrzejmidura.fivehanddrawpoker.service.UserService;

import java.util.Map;

@Controller
public class AuthController {
    private static final int INITIAL_CREDITS = 200;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @Autowired
    public AuthController(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@RequestParam Map<String, String> form) {
        String username = form.get("username");
        String encodedPassword = passwordEncoder.encode(form.get("password"));
        String email = form.get("email");

        User newUser = new User(username, email, encodedPassword, INITIAL_CREDITS);

        userService.addUser(newUser);
        return "register";
    }
}
