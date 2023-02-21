package shippingService.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippingService.dto.OrderDTO;
import shippingService.entity.Order;
import shippingService.entity.User;
import shippingService.enums.OrderStatus;
import shippingService.mapper.MapperOrder;
import shippingService.repository.OrderRepository;
import shippingService.repository.UserRepository;
import shippingService.service.OrderService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MapperOrder mapperOrder;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public OrderDTO create(OrderDTO dto) {
        log.info("User for create: {}",dto);//USER!!!!!
        Order order = new Order();
        order.setOrderStatus(OrderStatus.READY);

        User courier = userRepository.findById(dto.getCourier()).orElseThrow(() -> new Exception());
        Shop shop = shopRepository.findById(dto.getShop()).orElseThrow(()->new Exception());

        order.setCourier(courier);
        order.setShop(shop);
        courier.getDeliveredToUsers().add(order);
        shop.getOrders().add(order);

        orderRepository.save(order);
        userRepository.save(courier);
        shopRepository.save(shop);
        log.info("User created: {}",order);//User!!!
        return mapperOrder.toDto(order);
    }

    @Override
    public OrderDTO findOneById(Long id) {
        return mapperOrder.toDto(orderRepository.findById(id).stream().findFirst().orElseThrow());
    }

    @Override
    public OrderDTO update(OrderDTO dto) {///repair
         Order oldOrder = orderRepository.findById(dto.getId()).stream().findFirst().orElseThrow();
        oldOrder.setAddress(dto.getAddress());
        oldOrder.setOrderStatus(dto.getOrderStatus());
        oldOrder.setPrice(dto.getPrice());
        oldOrder.set();

        orderRepository.save(oldOrder);
         return mapperOrder.toDto(oldOrder);
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
