package az.company.itcompany.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginBean {

    private String username;
    private String password;
    private String role;
}
