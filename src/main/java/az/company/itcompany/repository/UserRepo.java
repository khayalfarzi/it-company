package az.company.itcompany.repository;

import az.company.itcompany.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    User getUserByUsernameAndPassword(String username, String password);

    @Query(value = "SELECT  * FROM users WHERE  role = 'OPERATOR'", nativeQuery = true)
    List<User> getListOfAllOperators();

    @Query(value = "UPDATE users SET status = false WHERE id = ?1", nativeQuery = true)
    void deleteUser(Long id);
}
