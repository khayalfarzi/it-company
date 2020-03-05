package az.company.itcompany.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment")
public class Payment {

    private Long insuranceId;

    private LocalDate paymentDate;

    private Double amount;

    private String debt;
}