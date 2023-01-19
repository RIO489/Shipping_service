package shippingService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order")
public class Order {
    @Id
    private Long id;
    private Long courierId;
    private Long customerId;
    private String orderStatus;
    private Long shopId;
    private String address;
    private BigDecimal price;
}

