package az.company.itcompany.services;

import az.company.itcompany.dao.LoginDao;
import az.company.itcompany.entities.LoginBean;
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
        LoginBean loginBean = new LoginBean(user.getUsername(), user.getPassword(), user.getRole());
        LoginDao loginDao = new LoginDao();

        String userValidate = loginDao.authenticateUser(loginBean);

        switch (userValidate) {
            case "SUPER_ADMIN":
                return "SUPER_ADMIN";
            case "ADMIN":/*
            HttpSession session = request.getSession();
            session.setAttribute("Admin", username);
            request.setAttribute("username", username);
            return session.getId();
*/
                return "ADMIN";
            case "OPERATOR":
                return "OPERATOR";
        }
        return null;
    }
}
