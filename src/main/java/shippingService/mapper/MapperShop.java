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
//    public static ShopDTO ToDTO(Optional<Shop> shop){
//        final ShopDTO shopDTO = new ShopDTO();
//
//        shopDTO.setId(shop.getId());
//        shopDTO.setShopName(shop.getShopName());
//        shopDTO.setShopOwnerID(shop.getShopOwnerID());
//        shopDTO.setAddress(shop.getAddress());
//        shopDTO.setHolidayID(shop.getHolidayID());
//        shopDTO.setTimeOpen(shop.getTimeOpen());
//        shopDTO.setTimeClose(shop.getTimeClose());
//
//        return shopDTO;
//    }

    public ShopDTO toDTO(Shop shop){
        final ShopDTO shopDTO = new ShopDTO();

        shopDTO.setId(shop.getId());
        shopDTO.setShopName(shop.getShopName());
        shopDTO.setShopOwner(mapperUser.toDto(shop.getShopOwner()));
        shopDTO.setAddress(shop.getAddress());
        shopDTO.setHolidays(shop.getHolidays());
        shopDTO.setTimeOpen(shop.getTimeOpen());
        shopDTO.setTimeClose(shop.getTimeClose());

        return shopDTO;
    }

    public Shop toEntity(ShopDTO shopDTO){
        final Shop shop = new Shop();

        shop.setId(shopDTO.getId());
        shop.setShopName(shopDTO.getShopName());
        shop.setAddress(shopDTO.getAddress());
        shop.setShopOwner(mapperUser.toEntity(shopDTO.getShopOwner()));
        shopDTO.setHolidays(shop.getHolidays());
        shop.setTimeClose(shopDTO.getTimeClose());
        shop.setTimeOpen(shopDTO.getTimeOpen());

        return shop;
    }
}
