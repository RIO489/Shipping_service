package shippingService.service;

import shippingService.dto.StorageDTO;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

public interface StorageService {
    List<StorageDTO> getAll();

    StorageDTO read(Long id);

    void delete(Long id);

    boolean  checkProduct(String shopName, String productName);

    //boolean deactivate(Long storageId);
    boolean activate(Long storageId);

    //boolean deactivate(Long shopId, Long productId);
    boolean activate(Long shopId, Long productId);
}
