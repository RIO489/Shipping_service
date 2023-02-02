package shippingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import shippingService.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query(value = "SELECT o FROM Order o WHERE o.courier_id= :courierId")
    List<Order> findAllByCourierId(Long courierId);

    @Query(value = "SELECT o FROM Order o WHERE o.id= :id")
    Order findAllById(Long id);

//    @Query(value = "SELECT o FROM Order")
//    List<Order> findAll();
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