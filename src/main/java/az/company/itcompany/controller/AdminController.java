package az.company.itcompany.controller;

import az.company.itcompany.entities.Role;
import az.company.itcompany.entities.User;
import az.company.itcompany.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/operator/save")
    public void save(@RequestBody User user){
        user.setRole(Role.OPERATOR.name());
        userService.save(user);
    }
}
