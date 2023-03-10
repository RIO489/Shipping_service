package shippingService.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shippingService.dto.ShopDTO;
import shippingService.entity.Shop;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ShopMapper {
    @Autowired
    private static MapperUser mapperUser;

    @Autowired
    private static HolidayMapper holidayMapper;

    public ShopDTO toDTO(Shop shop){
        final ShopDTO shopDTO = new ShopDTO();

        shopDTO.setId(shop.getId());
        shopDTO.setShopName(shop.getShopName());
        shopDTO.setShopOwner(mapperUser.toDto(shop.getShopOwner()));
        shopDTO.setAddress(shop.getAddress());
        shopDTO.setHolidays(shop.getHolidays().stream()
                .map(e -> holidayMapper.toDTO(e))
                .collect(Collectors.toList()));
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
        shop.setHolidays(shopDTO.getHolidays().stream()
                .map(e -> holidayMapper.toEntity(e))
                .collect(Collectors.toList()));
        shop.setTimeClose(shopDTO.getTimeClose());
        shop.setTimeOpen(shopDTO.getTimeOpen());

        return shop;
    }
}
