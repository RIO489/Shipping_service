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
    List<Shop> shops = new ArrayList<>();

//    @Query(value = "SELECT sh FROM shop sh WHERE sh.id= :shopId")
//    public ShopDTO findById(long shopId);


}
