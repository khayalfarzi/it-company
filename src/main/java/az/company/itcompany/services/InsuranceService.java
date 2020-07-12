package az.company.itcompany.services;

import az.company.itcompany.entities.Insurance;
import az.company.itcompany.repository.InsuranceRepo;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {

    private final InsuranceRepo insuranceRepo;

    public InsuranceService(InsuranceRepo insuranceRepo) {
        this.insuranceRepo = insuranceRepo;
    }

    public void save(Insurance insurance) {
        insurance.setNumberOfDays(insurance.getToDate().getDayOfYear() - insurance.getFromDate().getDayOfYear() + "");

        insuranceRepo.save(insurance);
    }
}
