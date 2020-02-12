package az.company.itcompany.services;

import az.company.itcompany.entities.Company;
import az.company.itcompany.repository.CompanyRepo;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRepo companyRepo;

    public CompanyService(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    public void save(Company company) {
        companyRepo.save(company);
    }
}
