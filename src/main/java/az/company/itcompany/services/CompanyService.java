package az.company.itcompany.services;

import az.company.itcompany.entities.Company;
import az.company.itcompany.repository.CompanyRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class CompanyService {

    private final CompanyRepo companyRepo;

    public CompanyService(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    public void save(Company company) {
        log.info("Company.save method is started.");

        companyRepo.save(company);

        log.info(String.format("Company.save method is stopped, Company successfully added. " +
                "Company name: %s   %s", company.getName(), company.getCreatedDate()));
    }

    public List<Company> getCompanyById(Long id) {
        List<Company> getAll = new ArrayList<>();

        log.info(String.format("Company.getCompanyById method is started : %s",
                LocalTime.now()));

        Optional<Company> getCompanyById = companyRepo.findById(id);
        getCompanyById.filter(getAll::add);

        log.info(String.format("Company.getCompanyById method is stopped : %s %s",
                getAll.get(0).getName(), LocalTime.now()));

        return getAll;
    }

    public List<Company> getListOfCompany() {
        return companyRepo.getListOfCompany();
    }

    public void deleteAll() {
        log.info(String.format("Company.deleteAll method is started : %s", LocalTime.now()));

        companyRepo.deleteAll();

        log.info(String.format("Company.deleteAll method is stopped : %s", LocalTime.now()));
    }
}
