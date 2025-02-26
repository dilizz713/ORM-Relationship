package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
/*@Data*/     // meke include wela thiyenwa getters , setters , tostring. eth getall method eka call karaddi error ekk enwa. stack overflow wenwa
            // e error ek enne tostring method ek call wena nisa. e nisa tostring ain karanna one.

@Getter
@Setter
/*@ToString*/

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

   /* @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)       //extra table ekak hedenwa table deke primaery keys use karal. aye table hadanna epa. meda table hadana eka nawattnwa meken
    private List<Order> orders;*/

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    //@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)

    private List<Order> orders;

   /* cascade walin wenne,
        All = okkoma change wenwa
        Persist = save wena ewa */

    //inverse side - foreign key ek dena kena
}
