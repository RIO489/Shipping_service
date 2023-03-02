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
        dto.setStorage_id(storage.getStorage_id());
        dto.setShop_id(mapperShop.toDTO(storage.getShop_id()));
        dto.setProduct_id(mapperProduct.toDto(storage.getProduct_id()));
        dto.setAvailable(storage.getAvailable());
        return dto;
    }

    public Storage toEntity(final StorageDTO dto) {
        final Storage storage = new Storage();
        storage.setStorage_id(dto.getStorage_id());
        storage.setShop_id(mapperShop.toEntity(dto.getShop_id()));
        storage.setProduct_id(mapperProduct.toEntity(dto.getProduct_id()));
        storage.setAvailable(dto.getAvailable());
        return storage;
    }
}
