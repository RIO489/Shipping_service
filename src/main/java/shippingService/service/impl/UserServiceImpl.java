package shippingService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippingService.dto.UserDTO;
import shippingService.entity.User;
import shippingService.mapper.MapperUser;
import shippingService.repository.UserRepository;
import shippingService.service.ProductService;
import shippingService.service.UserService;

import javax.transaction.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MapperUser mapperUser = new MapperUser();

    @Override
    public UserDTO create(UserDTO dto){
        User user = mapperUser.toEntity(dto);
        userRepository.save(user);
        return mapperUser.toDto(user);
    }



}
