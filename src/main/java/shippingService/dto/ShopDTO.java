package shippingService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopDTO {
    @Id
    @NotNull
    private long id;
    private String shopName;
    private String address;
    @Id
    private long shopOwnerID;
    private LocalDateTime timeOpen;
    private LocalDateTime timeClose;
    @Id
    private long holidayID;
}