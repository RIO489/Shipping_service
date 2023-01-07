package shipping_service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequestMapping("api")
public class shipping_test {

    @RequestMapping("/super")
    String home()  {
        String url = "jdbc:mysql://localhost:3306/shop";
        String name = "root";
        String password = "polapamax";
        try(Connection conn = DriverManager.getConnection(url,name,password);) {
            Statement statement = conn.createStatement();

            statement.executeUpdate("insert into test() value(5) ");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Hello world";
    }



}
