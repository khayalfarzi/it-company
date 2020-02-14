package az.company.itcompany.controller;

import az.company.itcompany.entities.User;
import az.company.itcompany.services.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public String login(@RequestBody User user) {
        String key = loginService.check(user.getUsername(), user.getPassword());
        return "Your access key:" + key;
    }
}
