package shippingService.service;

import shippingService.dto.UserDTO;
import shippingService.entity.User;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();
    UserDTO create(UserDTO userDTO);
    UserDTO findById(Long id);
    UserDTO update(UserDTO userDTO);
    void delete(Long id);
}
