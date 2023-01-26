package shippingService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Shop")
public class Shop {
    @Id
    @NonNull
    private Long id;
    private String shopName;
    private String address;
    private long shopOwnerID;
    private LocalDateTime timeOpen;
    private LocalDateTime timeClose;
    private long holidayID;
}
