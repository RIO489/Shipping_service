package shippingService.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shippingService.dto.UserDTO;
import shippingService.service.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping
    public UserDTO findById(@PathVariable final Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody final UserDTO userDTO) {
        return userService.create(userDTO);
    }

    @PutMapping
    public UserDTO updateUser(@RequestBody final UserDTO userDTO) {
        return userService.update(userDTO);
    }

    @DeleteMapping
    public ResponseEntity delete(@PathVariable final Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping({"/super"})
    String home() {
        final String url = "jdbc:mysql://localhost:3306/shop";
        final String name = "root";
        final String password = "polapamax";

        try {
            final Connection conn = DriverManager.getConnection(url, name, password);

            try {
                final Statement statement = conn.createStatement();
                statement.executeUpdate("insert into test() value(6) ");
            } catch (final Throwable var8) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (final Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            if (conn != null) {
                conn.close();
            }

            return "Hello world";
        } catch (final SQLException var9) {
            throw new RuntimeException(var9);
        }
    }
}
