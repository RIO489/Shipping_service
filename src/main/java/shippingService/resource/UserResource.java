package shippingService.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shippingService.dto.ShopOwnerDTO;
import shippingService.dto.UserDTO;
import shippingService.repository.UserRepository;
import shippingService.service.UserService;
import shippingService.service.impl.UserServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserResource {
    @Autowired
    private UserService userService = new UserServiceImpl();
    @Autowired UserRepository userRepository;

    @PostMapping("/create")
    public String create(@Valid @RequestBody final UserDTO userDTO) {
        userService.create(userDTO);
        return "All good";
    }

    @GetMapping("/{id}")
    public UserDTO read(final @PathVariable Long id) {
        return userService.read(id);
    }

    @PutMapping("/update")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO) {
        userService.update(userDTO);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/{id}")
    public String delete(final @PathVariable("id") Long id) {
        UserDTO userDTO = userService.read(id);
        userService.delete(id);
        return "User:" + userDTO.toString();
    }

    @GetMapping(value = "/all")
    public List<UserDTO> getAll() {
        return userService.getAll();
    }

    @PostMapping("/regOwner")
    public UserDTO registerOwner(@Valid @RequestBody ShopOwnerDTO shopOwner){
        UserDTO user = new UserDTO(shopOwner.getUserId(), shopOwner.getEmail(), shopOwner.getPassword(),
                shopOwner.getFirstName(), shopOwner.getLastName(), shopOwner.getUserRole(), shopOwner.isUserStatus());
        userService.registerShopOwner(shopOwner);
        return user;
    }

}

