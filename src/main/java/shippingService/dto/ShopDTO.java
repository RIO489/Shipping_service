package shippingService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shippingService.entity.Holiday;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopDTO {
    private Long id;
    private String shopName;
    private String address;
    private LocalDateTime timeOpen;
    private LocalDateTime timeClose;
    private List<Holiday> holidays;

    private Long shopOwnerID;
    //    private User shopOwner;
}