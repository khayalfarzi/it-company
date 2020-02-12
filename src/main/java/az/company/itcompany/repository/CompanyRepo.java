package az.company.itcompany.repository;

import az.company.itcompany.entities.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends CrudRepository<Company, Long> {
}
