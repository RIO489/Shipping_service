package shippingService.mapper;


import org.springframework.stereotype.Component;
import shippingService.dto.ShopDTO;
import shippingService.entity.Shop;

import java.util.Optional;

@Component
public class MapperShop {
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

    public static ShopDTO ToDTO(Shop shop){
        final ShopDTO shopDTO = new ShopDTO();

        shopDTO.setId(shop.getId());
        shopDTO.setShopName(shop.getShopName());
        shopDTO.setShopOwnerID(shop.getShopOwnerID());
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
        shop.setShopOwnerID(shopDTO.getShopOwnerID());
        shopDTO.setHolidays(shop.getHolidays());
        shop.setTimeClose(shopDTO.getTimeClose());
        shop.setTimeOpen(shopDTO.getTimeOpen());

        return shop;
    }
}
