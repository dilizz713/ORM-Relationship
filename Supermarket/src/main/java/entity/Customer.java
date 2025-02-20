package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//inverse side

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

    private String email;

    private String nic;

    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
    private List<Order> orders;
}
