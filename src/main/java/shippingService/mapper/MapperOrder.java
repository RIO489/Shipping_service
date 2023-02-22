package shippingService.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shippingService.dto.OrderDTO;
import shippingService.entity.Order;

@Component
public class MapperOrder {
    @Autowired
    private MapperUser mapperUser;
    @Autowired
    private MapperShop mapperShop;

    public OrderDTO toDto(final Order order) {
        final OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setAddress(order.getAddress());
        dto.setCustomer(mapperUser.toDto(order.getCustomer()));
        dto.setOrderStatus(order.getOrderStatus());
        dto.setPrice(order.getPrice());
        dto.setCourier(mapperUser.toDto(order.getCourier()));
        dto.setShop(mapperShop.ToDTO(order.getShop()));
        return dto;
    }
}
