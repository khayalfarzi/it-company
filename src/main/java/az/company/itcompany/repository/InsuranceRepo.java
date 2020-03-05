package az.company.itcompany.repository;

import az.company.itcompany.entities.Insurance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepo extends CrudRepository<Insurance, Long> {
}
