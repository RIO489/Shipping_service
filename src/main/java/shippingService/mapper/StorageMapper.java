package shippingService.mapper;

import org.springframework.stereotype.Component;
import shippingService.dto.StorageDTO;
import shippingService.dto.UserDTO;
import shippingService.entity.Storage;
import shippingService.entity.User;

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

    public Storage toEntity(final StorageDTO dto) {
        final Storage storage = new Storage();
        storage.setStorageID(dto.getStorageID());
        storage.setShopID(dto.getShopID());
        storage.setProductID(dto.getProductID());
        storage.setAvailable(dto.getAvailable());
        return storage;
    }
}
