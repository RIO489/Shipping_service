package shippingService.repository;

import org.hibernate.service.spi.ServiceException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shippingService.dto.OrderDTO;
import shippingService.entity.Order;

import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {

    String url = "jdbc:mysql://localhost:3306/shop";
    String name = "root";
    String password = "Riorio489@";

    List<Order> orders = new ArrayList<>();
    public void setOrders(final List<Order> orders) {
        this.orders = orders;
    }

    public void toSQL () {
        try {
            Connection conn = DriverManager.getConnection(url, name, password);
            for(Order order :  orders)
            try {
                Statement statement = conn.createStatement();
                statement.executeUpdate("INSERT INTO `shop`.`order`(" +
                        "`orderID`,`courierID`,`customerID`,`shopID`,`status`,`address`,`fullprice`)" +
                        "VALUES (" + order.getId().toString() + "," + order.getCourierId()+ ","  + order.getCustomerId()+ ","  + order.getShopId()+ "," +
                                "'" + order.getOrderStatus()+ "'"+ ","  + "'"+order.getAddress()+"'"+ ","  + order.getPrice().toString() +
                        "); ");
            } catch (Throwable var8) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }
                throw var8;
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var9) {
            throw new RuntimeException(var9);
        }
    }

    @PreDestroy
    public void preDestroy() {
        toSQL();
    }

    public void add(final Order order) {
        final Order finalOrder = new Order();
        finalOrder.setId(order.getId());
        finalOrder.setOrderStatus(order.getOrderStatus());
        finalOrder.setPrice(order.getPrice());
        finalOrder.setAddress(order.getAddress());
        finalOrder.setCustomerId(order.getCustomerId());
        finalOrder.setCourierId(order.getCourierId());
        finalOrder.setShopId(order.getShopId());
        orders.add(finalOrder);
    }
    public void add(final OrderDTO dto) {
        final Order finalOrder = new Order();
        finalOrder.setId(dto.getId());
        finalOrder.setOrderStatus(dto.getOrderStatus());
        finalOrder.setPrice(dto.getPrice());
        finalOrder.setAddress(dto.getAddress());
        finalOrder.setCustomerId(dto.getCustomerId());
        finalOrder.setCourierId(dto.getCourierId());
        finalOrder.setShopId(dto.getShopId());
        orders.add(finalOrder);
    }

    @Query("SELECT u FROM User u WHERE u.status = :orderId")
    Collection<Order> findAllActiveUsers(@Param("id") Long orderId) {//Work in Progress
        return null;
    };
    public Order findById(final Long id) {
        return orders.stream().filter(e -> e.getId().equals(id)).findFirst()
                .orElseThrow(() -> new ServiceException("No such id when finding"));
    }

    public Order findByCustomerId(final Long customerId) {
        return orders
                .stream()
                .filter(e -> e.getCustomerId().equals(customerId))
                .findFirst()
                .orElseThrow(() -> new ServiceException("No Account was found with this Client id:"+customerId));
    }
    public Order findByShopId(final String shopId) {
        return orders
                .stream()
                .filter(e -> e.getShopId().equals(shopId))
                .findFirst()
                .orElseThrow(() -> new ServiceException("No Account was found with this currency code:"+shopId));
    }

    public void update(final Long id, final OrderDTO dto) {
        final Order update = findById(id);
        update.setId(dto.getId());
        update.setAddress(dto.getAddress());
        update.setShopId(dto.getShopId());
        update.setOrderStatus(dto.getOrderStatus());
        update.setPrice(dto.getPrice());
        update.setCourierId(dto.getCourierId());
        update.setCustomerId(dto.getCustomerId());;
    }

    public void delete(final Long id) {
        setOrders(orders.stream().filter(e -> !e.getId().equals(id)).collect(Collectors.toList()));
    }

    public List<Order> getOrders () {
        return orders;
    }

}