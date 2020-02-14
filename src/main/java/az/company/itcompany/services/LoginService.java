package az.company.itcompany.services;

import az.company.itcompany.entities.User;
import az.company.itcompany.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserRepo userRepo;

    public LoginService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public String check(String username, String password) {
        User user = userRepo.getUserByUsernameAndPassword(username, password);
        if (user.getRole().equals("SUPER_ADMIN")) {
            return user.getRole();
        } else if (user.getRole().equals("ADMIN")) {
            return user.getRole();
        } else if (user.getRole().equals("OPERATOR")) return user.getRole();
        else return null;
    }
}
