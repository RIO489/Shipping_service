package shippingService.repository;

import org.hibernate.service.spi.ServiceException;
import shippingService.entity.Product;
import shippingService.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {
    private List<User> userList = new ArrayList<>();
    private Long id = 0L;

    public List<User> getAllUsers() {
        return new ArrayList<>(userList);
    }

    public User save(final User user){
        ++id;
        user.setId(id);
        userList.add(user);

        return user;
    }

    public User findById(final Long id){
        return userList.stream()
                .filter(e->e.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ServiceException("User can not be find by id:" + id));
    }

    public void delete(final Long id){
        userList = userList.stream()
                .filter(e-> !e.getId().equals(id))
                .collect(Collectors.toList());
    }

    public User update(final User user){
        final User saved = findById(user.getId());

        saved.setEmail(user.getEmail());
        saved.setFirstName(user.getFirstName());
        saved.setLastName(user.getLastName());
        saved.setUserRole(user.getUserRole());

        return saved;
    }
}
