package shippingService.mapper;

import shippingService.dto.UserDTO;
import shippingService.entity.User;

public class UserMapper {
    public UserDTO toDTO(final User user){
        final UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setUserRole(user.getUserRole());

        return userDTO;
    }

    public User toEntity(final UserDTO userDTO){
        final User user = new User();

        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUserRole(userDTO.getUserRole());

        return user;
    }
}
