package shippingService.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;
import shippingService.dto.UserDTO;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "address")
    private String address;

    @OneToOne
    private User shopOwner;


//    @DateTimeFormat(style = "hh:mm")
//    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "time_open")
    private LocalDateTime timeOpen;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "time_close")
    private LocalDateTime timeClose;

    @OneToMany(mappedBy = "shop")
    private List<Holiday> holidays;
}
