package az.company.itcompany.services;

import az.company.itcompany.entities.Role;
import az.company.itcompany.entities.User;
import az.company.itcompany.exceptions.NoDataFoundException;
import az.company.itcompany.exceptions.NotAllowException;
import az.company.itcompany.repository.UserRepo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        } else throw new NotAllowException(String.format("User not allowed exception: %s", LocalTime.now()));
    }

    public List<User> getListOfAdmins(String key) {
        List<User> userList = new ArrayList<>();

        if (key != null) {
            if (key.equals("SUPER_ADMIN")) {
                Iterable<User> userIterable = userRepo.findAll();
                userIterable.forEach(userList::add);
                return userList;
            } else if (key.equals("ADMIN")) {

                /*
                 * Some problem about token
                 * i don't know which admin coming
                 *
                 * */

                return null;
            } else throw new NotAllowException(String.format("%s: User can not access to take admins list", key));

        } else throw new NotAllowException("User haven't access key");
    }

    public List<User> getListOfAllOperators(String key) {
        if (key.equals("SUPER_ADMIN")) {
            return userRepo.getListOfAllOperators();
        } else
            throw new NotAllowException(String.format("%s: Only Super admin can get list of all operators", LocalTime.now()));
    }

    public User getUserById(Long id) {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isPresent()) {
            return userRepo.findById(id).get();
        } else throw new NoDataFoundException("User not found");
    }

    public void deleteUser(Long id, String key) {
        if (key.equals("SUPER_ADMIN")) {
            if (getUserById(id).getRole().equals("ADMIN")) {
                userRepo.deleteUser(id);
            } else throw new NotAllowException("User not allow to delete Admin");
        } else if (key.equals("ADMIN")) {
            if (getUserById(id).getRole().equals("OPERATOR")) {
                userRepo.deleteUser(id);
            } else throw new NotAllowException("User not allow to delete Operator");
        }
    }
}
