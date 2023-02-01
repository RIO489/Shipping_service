package shippingService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippingService.dto.OrderDTO;
import shippingService.entity.Order;
import shippingService.mapper.MapperOrder;
import shippingService.repository.OrderRepository;
import shippingService.service.OrderService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MapperOrder mapperOrder;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDTO create(OrderDTO dto) {
        Order order = new Order();
        order.setOrderStatus(dto.getOrderStatus());

        User courier = userRepository.findOneById(dto.getCourierId()).orElseThrow(() -> new Exception());
        Shop shop = shopRepository.findById(dto.getShopId()).orElseThrow(()->new Exception());

        order.setCourier(courier);
        order.setShop(shop);
        courier.getDeliveredToUsers().add(order);
        shop.getOrders().add(order);

        orderRepository.save(order);
        userRepository.save(courier);
        shopRepository.save(shop);

        return mapperOrder.toDto(order);
    }

    @Override
    public OrderDTO read(Long id) {
        return mapperOrder.toDto(orderRepository.findById(id).stream().findFirst().orElseThrow());
    }

    @Override
    public OrderDTO update(OrderDTO dto) {///repair
         orderRepository.save(mapperOrder.toEntity(dto));
         Order newOrder = orderRepository.findById(dto.getId()).stream().findFirst().orElseThrow();

         return mapperOrder.toDto(orderRepository.findById(dto.getId()).stream().findFirst().orElseThrow());
    }

    @Override
    public OrderDTO delete(Long id) {//Repair
        final OrderDTO deleted = mapperOrder.toDto((Order) orderRepository.findAllById(id));
         orderRepository.delete(id);
         return deleted;
    }

    @Override
    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream().map(mapperOrder::toDto).collect(Collectors.toList());//List<Long> -> List<Order>
    }
}
