package shippingService.mapper;

import org.springframework.stereotype.Component;
import shippingService.dto.OrderDTO;
import shippingService.entity.Order;

@Component
public class MapperOrder {
    public OrderDTO toDto(final Order order) {
        final OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setAddress(order.getAddress());
        dto.setCustomerId(order.getCustomer());
        dto.setOrderStatus(order.getOrderStatus());
        dto.setPrice(order.getPrice());
        dto.setCourierId(order.getCourier());
        dto.setShopId(order.getShopId());
        return dto;
    }
}
