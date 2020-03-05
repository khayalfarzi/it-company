package az.company.itcompany.dao;

import az.company.itcompany.entities.LoginBean;

public class LoginDao {

    public String authenticateUser(LoginBean loginBean) {
        switch (loginBean.getRole()) {
            case "SUPER_ADMIN":
                return "SUPER_ADMIN";
            case "ADMIN":
                return "ADMIN";
            case "OPERATOR":
                return "OPERATOR";
            default:
                return "nodata";
        }
    }
}
