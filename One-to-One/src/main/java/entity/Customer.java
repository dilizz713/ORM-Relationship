package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer_table")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)             //identity eken thmy database eke id eka  auto generate wenne.hebei user manually id add krnwa nm mewa denna behe
    //AUTO - hibernate decided auto value
    //IDENTITY - database generate auto value
    //For custom value don't use @GeneratedValue
    //Auto or IDENTITY danawa nm ewa int wenna one
    private int id;
    private String name;

    @OneToOne
    @JoinColumn(name = "nic_number")            //column ekata name ekak denna puluwan
    private IDCard idCard;
}
