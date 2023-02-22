package shippingService.service;

import shippingService.dto.OrderDTO;
import shippingService.exception.ServiceImplException;

import java.util.List;

public interface OrderService {
    OrderDTO create(OrderDTO dto) throws ServiceImplException;

    OrderDTO findOneById(Long id);

    OrderDTO update(OrderDTO dto);

    void delete(Long id);

    List<OrderDTO> getAll();
}
