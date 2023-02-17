package shippingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import shippingService.dto.ShopDTO;
import shippingService.entity.Shop;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

}
