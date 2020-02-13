package az.company.itcompany.controller;

import az.company.itcompany.entities.Company;
import az.company.itcompany.entities.Role;
import az.company.itcompany.entities.User;
import az.company.itcompany.services.CompanyService;
import az.company.itcompany.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sa")
public class SuperAdminController {
    private final CompanyService companyService;
    private final UserService userService;

    public SuperAdminController(CompanyService companyService, UserService userService) {
        this.companyService = companyService;
        this.userService = userService;
    }

    @GetMapping("/company/getAll")
    public List<Company> getListOfCompany() {
        return companyService.getListOfCompany();
    }

    @PostMapping("/company/save")
    public String save(@RequestBody Company company) {
        company.setStatus(true);

        companyService.save(company);

        return String.format("Your access key : %s", company.getId());
    }

    @PostMapping("/admin/save")
    public String save(@RequestBody User user) {

        user.setRole(Role.ADMIN.name());

        userService.save(user);

        return String.format("Successfully added: %s", user.getName());
    }
}
