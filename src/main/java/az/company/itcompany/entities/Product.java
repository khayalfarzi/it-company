package az.company.itcompany.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Double firstAmount;

    private Double secondAmount;

    private Double thirdAmount;

    private String commissionCost;

    private Company company;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstAmount=" + firstAmount +
                ", secondAmount=" + secondAmount +
                ", thirdAmount=" + thirdAmount +
                ", commissionCost='" + commissionCost + '\'' +
                ", company=" + company +
                '}';
    }
}