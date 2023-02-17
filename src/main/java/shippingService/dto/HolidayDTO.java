package shippingService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shippingService.entity.Shop;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HolidayDTO {
    private Long id;
    private LocalDateTime timeOpen;
    private LocalDateTime timeClose;
    private String title;
    private Shop shop;
}
