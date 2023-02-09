package shippingService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shop")
public class Shop {
    @Id
    private Long id;
    @Column(name = "shop_name")
    private String shopName;
    @Column(name = "address")
    private String address;
//    @OneToOne
//    private User shopOwner;
    private long shopOwnerID;
    @Column(name = "time_open")
    private LocalDateTime timeOpen;
    @Column(name = "time_close")
    private LocalDateTime timeClose;
    private List<Holiday> holidays;
}
