package shippingService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import shippingService.dto.ShopDTO;
import shippingService.dto.ShopOwner;
import shippingService.dto.UserDTO;
import shippingService.entity.User;
import shippingService.mapper.MapperShop;
import shippingService.mapper.MapperUser;
import shippingService.repository.ShopRepository;
import shippingService.repository.UserRepository;
import shippingService.service.UserService;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private MapperUser mapperUser = new MapperUser();
    @Autowired
    private MapperShop mapperShop;

    @Override
    public UserDTO create(UserDTO dto) {
        User user = mapperUser.toEntity(dto);
        userRepository.save(user);
        return mapperUser.toDto(user);
    }

    @Override
    public UserDTO read(Long id) {
        return mapperUser.toDto(userRepository.findById(id).orElseThrow());
    }

    @Override
    public void update(UserDTO dto) {
        User user = mapperUser.toEntity(dto);
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(userRepository.findById(id).orElseThrow());
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(mapperUser::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDTO registerShopOwner(ShopOwner shopOwner){
        UserDTO user = new UserDTO(shopOwner.getUserId(), shopOwner.getEmail(), shopOwner.getPassword(),
                shopOwner.getFirstName(), shopOwner.getLastName(), shopOwner.getUserRole(), shopOwner.isUserStatus());
        ShopDTO shop = new ShopDTO(shopOwner.getShopId(), shopOwner.getShopName(), shopOwner.getAddress(),
                shopOwner.getTimeOpen(),shopOwner.getTimeClose(), shopOwner.getHolidays(), user);

        userRepository.save(mapperUser.toEntity(user));
        shopRepository.save(MapperShop.ToEntity(shop));
        return user;
    }
}
