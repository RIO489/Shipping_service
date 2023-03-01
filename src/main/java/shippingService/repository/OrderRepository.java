package shippingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import shippingService.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query(value = "SELECT o FROM Order o WHERE o.courier.id= :courier_Id")
    List<Order> findAllByCourierId(Long courier_Id);
}