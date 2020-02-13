package az.company.itcompany.controller;

import az.company.itcompany.entities.User;
import az.company.itcompany.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
