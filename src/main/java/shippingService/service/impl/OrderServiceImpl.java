package shippingService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import shippingService.dto.OrderDTO;
import shippingService.entity.Order;
import shippingService.mapper.MapperOrder;
import shippingService.repository.OrderRepository;
import shippingService.service.OrderService;

import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    @Autowired
    final MapperOrder mapperOrder = new MapperOrder();
    @Autowired
    final OrderRepository orderRepository = new OrderRepository();
    @Override
    public OrderDTO create(OrderDTO dto) {
        orderRepository.add(dto);
        final Order accountInRepos = orderRepository.getOrders().get(orderRepository.getOrders().size() - 1);
        orderRepository.toSQL();
        return mapperOrder.toDto(accountInRepos);
    }

    @Override
    public OrderDTO read(Long id) {
        return mapperOrder.toDto(orderRepository.findById(id));
    }

    @Override
    public OrderDTO update(OrderDTO dto) {
         orderRepository.update(dto.getId(),dto);
         return mapperOrder.toDto(orderRepository.findById(dto.getId()));
    }

    @Override
    public OrderDTO delete(Long id) {
        final OrderDTO deleted = mapperOrder.toDto(orderRepository.findById(id));
         orderRepository.delete(id);
         return deleted;
    }

    @Override
    public List<OrderDTO> getAll() {
        return orderRepository.getOrders().stream().map(mapperOrder::toDto).collect(Collectors.toList());
    }
}
