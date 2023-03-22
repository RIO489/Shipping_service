package shippingService.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shippingService.entity.Holiday;
import shippingService.enums.UserRole;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopOwnerDTO {
    //User
    private Long userId;
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private UserRole userRole;
    @NotNull
    boolean userStatus;
    //Shop
    private Long shopId;
    private String shopName;
    private String address;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timeOpen;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timeClose;
    private List<Holiday> holidays;
}
