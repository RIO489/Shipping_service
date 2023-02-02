package shippingService.mapper;

import org.springframework.stereotype.Component;
import shippingService.dto.StorageDTO;
import shippingService.entity.Storage;

@Component
public class StorageMapper {

    public StorageDTO toDto(final Storage storage) {
        final StorageDTO dto = new StorageDTO();
        dto.setStorageID(storage.getStorageID());
        dto.setShopID(storage.getShopID());
        dto.setProductID(storage.getProductID());
        dto.setAvailable(storage.getAvailable());
        return dto;
    }
}
