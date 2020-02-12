package az.company.itcompany.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "company", schema = "workplace")
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String address;

    private String mobileNumber;

    private String officeNumber;

    private Date createdDate;

    private String logo;

    private boolean status;

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", officeNumber='" + officeNumber + '\'' +
                ", createdDate=" + createdDate +
                ", logo='" + logo + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}