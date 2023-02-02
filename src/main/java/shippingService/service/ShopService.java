package shippingService.service;

import shippingService.dto.ShopDTO;
import shippingService.entity.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopService {
    ShopDTO create(ShopDTO shopDTO);

    void delete(long id);

    ShopDTO update(ShopDTO shopDTO);

    List<ShopDTO> getAll();

    ShopDTO findById(long id);
}
