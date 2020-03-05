package az.company.itcompany.controller;

import az.company.itcompany.entities.Company;
import az.company.itcompany.entities.User;
import az.company.itcompany.services.CompanyService;
import az.company.itcompany.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GeneralController {

    private final UserService userService;
    private final CompanyService companyService;

    public GeneralController(UserService userService, CompanyService companyService) {
        this.userService = userService;
        this.companyService = companyService;
    }


    /**
     * General save method, all of users registered here
     * <p>
     * Roles:
     * - SUPER_ADMIN
     * - ADMIN
     * - OPERATOR
     * <p>
     * SUPER_ADMIN can not be registered because we have only one SUPER_ADMIN
     * SUPER_ADMIN must registered admins and companies
     * ADMIN must registered OPERATORS , also admin can not registered admin
     * <p>
     * And when user want to register he/she enter her/him email address, and we send activation url,
     * after user activation, the status of the user become true
     */
    @PostMapping("/save")
    public String save(@RequestBody User user, @RequestParam("key") String key) {
        userService.save(user, key);
        return String.format("Successfully added user. %s", user.getName());
    }


    /**
     * only SUPER_ADMIN can registered Company, also he/she can create admin and
     * admins manage company
     */
    @PostMapping("/company/save")
    public String save(@RequestBody Company company, @RequestParam("key") String key) {
        companyService.save(company, key);
        return String.format("Your access key : %s", company.getId());
    }


    /**
     * - Super admin can get list of all admins with their corresponding companies
     * - Admin can get other admins of his/her company
     */
    @GetMapping("/admin/getAll")
    public List<User> getListOfAdmins(String key) {
        return userService.getListOfAdmins(key);
    }


    /**
     * - Super admin can get list of all companies
     */
    @GetMapping("/company/getAll")
    public List<Company> getListOfCompany(@RequestParam("key") String key) {
        return companyService.getListOfCompany(key);
    }


    /**
     * - Admin can get list of operators who works with it
     * - Super admin can get list of all operators
     */
    @GetMapping("/operator/getAll")
    public List<User> getListOfAllOperators(@RequestParam("key") String key) {
        return userService.getListOfAllOperators(key);
    }


    /**
     * - Only Super admin can delete all companies
     */
    @GetMapping("/company/deleteAll")
    public String deleteAll(String key) {
        companyService.deleteAll(key);
        return "successfully deleted";
    }


    /**
     * - Only Super admin can get all companies
     */
    @GetMapping("/company/get")
    public List<Company> getCompanyById(@RequestParam("id") Long id, @RequestParam("key") String key) {
        return companyService.getCompanyById(id, key);
    }


    /**
     * - Only Super admin can delete admin
     * - Only Admin can delete operator
     */
    @PostMapping("/admin/delete")
    public void deleteUser(@RequestParam("id") Long id, @RequestParam("key") String key) {
        userService.deleteUser(id, key);
    }
}
