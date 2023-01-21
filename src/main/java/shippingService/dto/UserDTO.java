package shippingService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @Id
    private Long id;
    @Email
    String email;
    @NotNull
    String password;
    @NotNull
    String firstName;
    @NotNull
    String lastName;
    @NotNull
    String userRole;
    @NotNull
    boolean userStatus;
}

