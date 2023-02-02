package shippingService.service;

import shippingService.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO create(OrderDTO dto);

    OrderDTO findOneById(Long id);

    OrderDTO update(OrderDTO dto);

    OrderDTO delete(Long id);

    List<OrderDTO> getAll();
}
