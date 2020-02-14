package az.company.itcompany.repository;

import az.company.itcompany.entities.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepo extends CrudRepository<Company, Long> {

    @Query(value = "select * from company.companies", nativeQuery = true)
    List<Company> getListOfCompany();
}
