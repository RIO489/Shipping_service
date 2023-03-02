package shippingService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "storage")
@Entity
public class Storage implements Serializable {

    // передивитись зв'язки + перед пушом поміняти пароль від бд

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storage_id;

    @OneToOne
    @JoinColumn(name = "shop_id")
    private Shop shop_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product_id;

    @Column(name = "available")
    private Boolean available;
}
