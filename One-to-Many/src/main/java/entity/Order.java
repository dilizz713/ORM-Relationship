package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

/*@Data*/

@Getter
@Setter
/*@ToString*/

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;

    @ManyToOne
    private Customer customer;

    //owning side - foreign key eka aithi meyata


}
