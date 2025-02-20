package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_details")
public class OrderDetails {

    @EmbeddedId
    private OrderDetailsID id;

    @Column(name = "unit_price" , scale = 2)
    private BigDecimal unitPrice;

    private int qty;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order orders;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    private Item items;
}
