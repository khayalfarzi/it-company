package az.company.itcompany.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user", schema = "workplace")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    private String username;

    private String password;

    private boolean status;

    private Company company;

    private Date registerDate;

    private String phoneNumber;

    private Date lastLoginDate;

    private Role role;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", company=" + company +
                ", registerDate=" + registerDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", lastLoginDate=" + lastLoginDate +
                ", role=" + role +
                '}';
    }
}
