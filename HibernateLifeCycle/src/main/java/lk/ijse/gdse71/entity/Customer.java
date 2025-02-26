package lk.ijse.gdse71.entity;

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
    @Column(name = "customer_id")
    private String id;

    private String name;

    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)       //extra table ekak hedenwa table deke primaery keys use karal. aye table hadanna epa. meda table hadana eka nawattnwa meken
    private List<Order> orders;

}

