package shippingService.service;

import org.springframework.security.core.userdetails.UserDetails;
import shippingService.dto.ShopOwner;
import shippingService.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO create(UserDTO dto);

    UserDTO read(Long id);

    void update(UserDTO dto);

    void delete(Long id);

    List<UserDTO> getAll();
    UserDTO registerShopOwner(ShopOwner shopOwner);

}
