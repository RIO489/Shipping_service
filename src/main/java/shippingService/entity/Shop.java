package shippingService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
    private String shopName;
    private String address;
//    @OneToOne
//    private User shopOwner;
    private long shopOwnerID;
    private LocalDateTime timeOpen;
    private LocalDateTime timeClose;
    private List<Holiday> holidays;
}
