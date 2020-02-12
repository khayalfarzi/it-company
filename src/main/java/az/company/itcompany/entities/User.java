package az.company.itcompany.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "user", schema = "workplace")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    private String username;

    private String password;

    private boolean status;

    private Company company;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date registerDate;

    private String phoneNumber;

    @LastModifiedDate
    private Date lastLoginDate;

    private Role role;

    @OneToMany(targetEntity = Company.class, mappedBy = "user", fetch = FetchType.EAGER)
    private List<Company> companyId = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", company=" + company +
                ", registerDate=" + registerDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", lastLoginDate=" + lastLoginDate +
                ", role=" + role +
                ", companyId=" + companyId +
                '}';
    }
}
