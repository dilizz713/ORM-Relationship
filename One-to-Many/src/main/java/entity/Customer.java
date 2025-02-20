package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)       //extra table ekak hedenwa table deke primaery keys use karal. aye table hadanna epa. meda table hadana eka nawattnwa meken
    private List<Order> orders;

   /* cascade walin wenne,
        All = okkoma change wenwa
        Persist = save wena ewa */

    //inverse side - foreign key ek dena kena
}
