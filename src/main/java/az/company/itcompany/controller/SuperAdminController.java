package az.company.itcompany.controller;

import az.company.itcompany.entities.Company;
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
    public List<Company> getListOfCompany(@RequestParam("key") String key) {
        return companyService.getListOfCompany(key);
    }

    @PostMapping("/company/save")
    public String save(@RequestBody Company company,
                       @RequestParam("key") String key) {

        companyService.save(company, key);

        return String.format("Your access key : %s", company.getId());
    }

    @PostMapping("/admin/save")
    public String save(@RequestBody User user,
                       @RequestParam("key") String key) {
        userService.save(user, key);
        return "Okay";
    }

    @GetMapping("/deleteAll")
    public String deleteAll(String key) {
        companyService.deleteAll(key);
        return "successfully deleted";
    }

    @GetMapping("/get")
    public List<Company> getCompanyById(@RequestParam("id") Long id,
                                        @RequestParam("key") String key) {
        return companyService.getCompanyById(id, key);
    }

}
