package shippingService.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;
import shippingService.entity.Holiday;
import shippingService.entity.User;

import javax.persistence.Id;
import javax.persistence.TemporalType;
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
//    @DateTimeFormat(style = "hh:mm")
//    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm")
    private Long shopOwnerId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timeOpen;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timeClose;
    private List<Holiday> holidays;

}