package az.company.itcompany.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "insurance")
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //-fromDate>=registerDate +1
    private LocalDate fromDate;
    /**
     * fromDate until toDate: IN_PROGRESS
     * <p>
     * after toDate: DE_ACTIVE
     */
    private LocalDate toDate;

    //-policyNumber is unique = client.fin+random string(5 numbers)
    private String policyNumber;

    /**
     * -insuranceCost calculation depends on numberOfDays.
     * <p>
     * If:
     * numberOfDays = 30 then numberOfDays = numberOfDays *
     * product.firstAmount;
     * numberOfDays = 60 then numberOfDays = numberOfDays *
     * product.secondAmount ;
     * numberOfDays = 90 then numberOfDays = numberOfDays *
     * product.thirdAmount
     */
    private Double insuranceCost;

    //-numberOfDays = toDate-fromDate
    private String numberOfDays;

    private String product;

    //-status can be ACTIVE,IN_PROGRESS,DE_ACTIVE.
    private Status status;

    //-paymentStatus can be PAID,UNPAID. It depends on payment module.
    private PaymentStatus paymentStatus;

    //On register date: ACTIVE
    private LocalDate registerDate;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private String createdBy;
}
