package shippingService.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shippingService.dto.ProductDTO;
import shippingService.dto.UserDTO;
import shippingService.repository.UserRepository;
import shippingService.service.UserService;
import shippingService.service.impl.UserServiceImpl;

import javax.validation.Valid;

@RestController
@RequestMapping("api/user")
public class UserResource {
    @Autowired
    private UserService userService = new UserServiceImpl();

    @PostMapping("/create")
    public String create(@Valid @RequestBody final UserDTO userDTO){
        userService.create(userDTO);
        return "All good";
    }
}

