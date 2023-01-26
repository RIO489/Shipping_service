package shippingService.mapper;

import org.springframework.stereotype.Component;
import shippingService.dto.UserDTO;
import shippingService.entity.User;

@Component
public class MapperUser {
    public UserDTO toDto(final User user) {
        final UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setUserRole(user.getUserRole());
        dto.setUserStatus(user.isUserStatus());
        return dto;
    }

    public User toEntity(final UserDTO dto) {
        final User user = new User();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setUserRole(dto.getUserRole());
        user.setUserStatus(dto.isUserStatus());
        return user;
    }
}
