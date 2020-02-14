package az.company.itcompany.repository;

import az.company.itcompany.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    @Query(value = "SELECT * FROM users WHERE username=?1 AND password=?2", nativeQuery = true)
    public User getUserByUsernameAndPassword(String username, String password);
}
