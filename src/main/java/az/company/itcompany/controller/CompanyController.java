package az.company.itcompany.controller;

import az.company.itcompany.entities.Company;
import az.company.itcompany.services.CompanyService;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/get")
    public List<Company> getCompanyById(@RequestParam("id") Long id) {
        return companyService.getCompanyById(id);
    }

    @GetMapping("/deleteAll")
    public String deleteAll() {
        companyService.deleteAll();
        return "successfully deleted";
    }
}
