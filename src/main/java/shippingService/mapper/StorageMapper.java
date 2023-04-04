package shippingService.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shippingService.dto.StorageDTO;
import shippingService.dto.UserDTO;
import shippingService.entity.Storage;
import shippingService.entity.User;

@Component
public class StorageMapper {

    @Autowired
    public MapperProduct mapperProduct;

    @Autowired
    public MapperShop mapperShop;

    public StorageDTO toDto(final Storage storage) {
        final StorageDTO dto = new StorageDTO();
        dto.setStorageId(storage.getStorageId());
        dto.setShopId(mapperShop.toDTO(storage.getShopId()));
        dto.setProductId(mapperProduct.toDto(storage.getProductId()));
        dto.setAvailable(storage.getAvailable());
        return dto;
    }
}
