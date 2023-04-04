package shippingService.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shippingService.dto.ShopDTO;
import shippingService.entity.Shop;

import java.util.Optional;

@Component
public class MapperShop {
    @Autowired
    private static MapperUser mapperUser;

    public ShopDTO ToDTO(Shop shop){
        final ShopDTO shopDTO = new ShopDTO();

        shopDTO.setId(shop.getId());
        shopDTO.setShopName(shop.getShopName());
        shopDTO.setShopOwnerId(shop.getShopOwnerId());
        shopDTO.setAddress(shop.getAddress());
        shopDTO.setHolidays(shop.getHolidays());
        shopDTO.setTimeOpen(shop.getTimeOpen());
        shopDTO.setTimeClose(shop.getTimeClose());

        return shopDTO;
    }

    public static Shop ToEntity(ShopDTO shopDTO){
        final Shop shop = new Shop();

        shop.setId(shopDTO.getId());
        shop.setShopName(shopDTO.getShopName());
        shop.setAddress(shopDTO.getAddress());
        shop.setShopOwnerId(shop.getShopOwnerId());
        shopDTO.setHolidays(shop.getHolidays());
        shop.setTimeClose(shopDTO.getTimeClose());
        shop.setTimeOpen(shopDTO.getTimeOpen());


        return shop;
    }
}
