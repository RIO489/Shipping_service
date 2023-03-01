package shippingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shippingService.entity.Holiday;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Long> {

}
