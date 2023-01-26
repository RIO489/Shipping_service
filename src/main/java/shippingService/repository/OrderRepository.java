package shippingService.repository;

import org.hibernate.service.spi.ServiceException;
import org.springframework.data.jpa.repository.JpaRepository;
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
public interface OrderRepository extends JpaRepository<Long, Order> {
    List<Order> orders = new ArrayList<>();
    @Query(value = "SELECT u FROM Order u WHERE u.courier_id= :courier_id")
    List<Order> findAllByCourierId(Long courier_id);

    @Query(value = "SELECT u FROM Order u WHERE u.id= :id")
    List<Order> findAllById(Long id);

    /*public Order findByCustomerId(final Long customerId) {
        return orders
                .stream()
                .filter(e -> e.getCustomerId().equals(customerId))
                .findFirst()
                .orElseThrow(() -> new ServiceException("No Account was found with this Client id:" + customerId));
    }

    public Order findByShopId(final String shopId) {
        return orders
                .stream()
                .filter(e -> e.getShopId().equals(shopId))
                .findFirst()
                .orElseThrow(() -> new ServiceException("No Account was found with this currency code:" + shopId));
    }

    public void update(final Long id, final OrderDTO dto) {
        final Order update = findById(id);
        update.setId(dto.getId());
        update.setAddress(dto.getAddress());
        update.setShopId(dto.getShopId());
        update.setOrderStatus(dto.getOrderStatus());
        update.setPrice(dto.getPrice());
        update.setCourierId(dto.getCourierId());
        update.setCustomerId(dto.getCustomerId());
        ;
    }

    public void delete(final Long id) {
        setOrders(orders.stream().filter(e -> !e.getId().equals(id)).collect(Collectors.toList()));
    }

    public List<Order> getOrders() {
        return orders;
    }
*/
}