package shippingService.mapper;

import shippingService.dto.OrderDTO;
import shippingService.entity.Order;


public class MapperOrder {

    public OrderDTO toDto(final Order order) {
        final OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setAddress(order.getAddress());
        dto.setCustomerId(order.getCustomerId());
        dto.setOrderStatus(order.getOrderStatus());
        dto.setPrice(order.getPrice());
        dto.setCourierId(order.getCourierId());
        dto.setShopId(order.getShopId());
        return dto;
    }
}
