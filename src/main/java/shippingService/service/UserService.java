package shippingService.service;

import shippingService.dto.ProductDTO;
import shippingService.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO create(UserDTO dto);

    /*UserDTO read(Long id);

    UserDTO update(UserDTO dto);

    UserDTO delete(Long id);

    List<UserDTO> getAll();*/
}