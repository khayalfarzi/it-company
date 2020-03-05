package az.company.itcompany.controller;

import az.company.itcompany.entities.User;
import az.company.itcompany.services.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    /**
     * \\================================================================================\\
     * \\ when users want to login our security give her/him fake token (security key)   \\
     * \\ and when user want to do operations he/she use that key for access             \\
     * \\ token is standard yet, when i finish task i try to solve that                  \\
     * \\                                                                                \\
     * \\ Actually we can not create security that's why we need to use token or session \\
     * \\ it's test project and i don't want to spoil my time authentication             \\
     * \\ if i see i have a lot of time then i try to solve this simple problem :)       \\
     * \\================================================================================\\
     */
    @PostMapping
    public String login(@RequestBody User user) {
        String key = loginService.check(user.getUsername(), user.getPassword());
        return "Your access key:" + key;
    }
}
