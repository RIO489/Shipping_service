package shippingService.service;

import shippingService.dto.StorageDTO;

import java.math.BigInteger;
import java.util.UUID;

public interface StorageService {
    StorageDTO create(StorageDTO dto);

    StorageDTO read(BigInteger id);

    StorageDTO update(StorageDTO dto);

    StorageDTO delete(BigInteger id);
}
