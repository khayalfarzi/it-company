package az.company.itcompany.services;

import az.company.itcompany.entities.Role;
import az.company.itcompany.entities.User;
import az.company.itcompany.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void save(User user, String key) {

        if (key.equals("SUPER_ADMIN")) {

            user.setRole(Role.ADMIN.name());
            userRepo.save(user);

        } else if (key.equals("ADMIN")) {

            user.setRole(Role.OPERATOR.name());
            userRepo.save(user);
        }
    }
}
