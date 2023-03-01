package shippingService.service;

import shippingService.dto.ShopDTO;
import shippingService.dto.StorageDTO;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

public interface StorageService {
    List<StorageDTO> getAll();

    StorageDTO create(StorageDTO dto);

    StorageDTO read(Long id);

    void update(StorageDTO dto);

    void delete(Long id);

    void checkProduct(String shopName, String productName);
}
