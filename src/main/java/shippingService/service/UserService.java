package shippingService.service;

import shippingService.dto.ShopOwnerDTO;
import shippingService.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO create(UserDTO dto);

    UserDTO read(Long id);

    void update(UserDTO dto);

    void delete(Long id);

    List<UserDTO> getAll();
    UserDTO registerShopOwner(ShopOwnerDTO shopOwner);

}
