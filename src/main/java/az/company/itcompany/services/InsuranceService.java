package az.company.itcompany.services;

import az.company.itcompany.repository.InsuranceRepo;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {

    private final InsuranceRepo insuranceRepo;

    public InsuranceService(InsuranceRepo insuranceRepo) {
        this.insuranceRepo = insuranceRepo;
    }
}
