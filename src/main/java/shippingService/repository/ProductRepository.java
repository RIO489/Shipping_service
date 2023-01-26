package shippingService.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shippingService.dto.ProductDTO;
import shippingService.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
