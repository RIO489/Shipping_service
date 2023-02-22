package shippingService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shippingService.enums.OrderStatus;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "courier_id")
    private User courier;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @OneToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;
    private String address;
    private BigDecimal price;
}