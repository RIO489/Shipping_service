package shippingService.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippingService.dto.UserDTO;
import shippingService.entity.Product;
import shippingService.entity.User;
import shippingService.mapper.UserMapper;
import shippingService.repository.UserRepository;
import shippingService.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO create(final UserDTO userDTO) {
        final User user = userMapper.toEntity(userDTO);
        userRepository.save(user);
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO findById(final Long id) {
        return userMapper.toDTO(userRepository.findById(id));
    }

    @Override
    public UserDTO update(final UserDTO userDTO) {
        final User user = userMapper.toEntity(userDTO);

        userRepository.update(user);

        return userMapper.toDTO(user);
    }

    @Override
    public void delete(final Long id) {
        userRepository.delete(id);
    }
}
