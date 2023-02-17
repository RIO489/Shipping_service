package shippingService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "holiday")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time_open")
    private LocalDateTime timeOpen;

    @Column(name = "time_close")
    private LocalDateTime timeClose;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;
}
