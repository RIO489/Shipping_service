package shippingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shippingService.entity.Storage;


@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {
}
