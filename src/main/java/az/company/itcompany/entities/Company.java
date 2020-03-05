package az.company.itcompany.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "companies")
@NoArgsConstructor
@AllArgsConstructor
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @Size(min = 5, max = 20, message = "The company name must contain at least 5 characters maximum 20 characters")
    private String name;

    //    @Size(min = 7, max = 30, message = "The company address must contain at least 7 characters maximum 30 characters")
    private String address;

    //    @Size(min = 7, max = 20, message = "The company mobile number must contain at least 7 characters maximum 20 characters")
    private String mobileNumber;

    //    @Size(min = 3, max = 7, message = "The company office number must contain at least 3 characters maximum 7 characters")
    private String officeNumber;

    @CreationTimestamp
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
