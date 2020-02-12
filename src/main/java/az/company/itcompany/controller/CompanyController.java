package az.company.itcompany.controller;

import az.company.itcompany.entities.Company;
import az.company.itcompany.services.CompanyService;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/creat")
    public String save(@RequestParam("name") String name,
                       @RequestParam("address") String address,
                       @RequestParam("mobileNumber") String mobileNumber,
                       @RequestParam("officeNumber") String officeNumber,
                       @RequestParam("logo") String logo) {
        Company company = new Company();
        company.setName(name);
        company.setAddress(address);
        company.setMobileNumber(mobileNumber);
        company.setOfficeNumber(officeNumber);
        company.setLogo(logo);
        company.setStatus(true);

        companyService.save(company);

        return "Successfully added...";
    }
}
