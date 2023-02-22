package shippingService.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippingService.dto.OrderDTO;
import shippingService.entity.Order;
import shippingService.entity.Shop;
import shippingService.entity.User;
import shippingService.enums.OrderStatus;
import shippingService.exception.ServiceImplException;
import shippingService.mapper.MapperOrder;
import shippingService.mapper.MapperUser;
import shippingService.repository.OrderRepository;
import shippingService.repository.ShopRepository;
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
    private MapperUser mapperUser;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShopRepository shopRepository;

    @Override
    public OrderDTO create(OrderDTO dto) throws ServiceImplException {
        log.info("Order for create: {}",dto);//ORDER!!!!!
        Order order = new Order();
        order.setOrderStatus(OrderStatus.PENDING);

        User courier = userRepository.findById(dto.getCourier().getId()).orElseThrow(() -> new ServiceImplException("Can`t find User by this ID: " + dto.getCourier().getId()));
        Shop shop = shopRepository.findById(dto.getShop().getId()).orElseThrow(()->new ServiceImplException("Can`t find Shop by this ID: "+dto.getShop().getId()));

        order.setCourier(courier);
        order.setShop(shop);
/*        courier.getDeliveredToUsers().add(order);
        shop.getOrders().add(order);*/

        orderRepository.save(order);
        userRepository.save(courier);
        shopRepository.save(shop);
        log.info("Order created: {}",order);//Order!!!
        return mapperOrder.toDto(order);
    }

    @Override
    public OrderDTO findOneById(Long id) {
        return mapperOrder.toDto(orderRepository.findById(id).stream().findFirst().orElseThrow());
    }

    @Override
    public OrderDTO update(OrderDTO dto) {
         Order oldOrder = orderRepository.findById(dto.getId()).stream().findFirst().orElseThrow();
        oldOrder.setAddress(dto.getAddress());
        oldOrder.setOrderStatus(dto.getOrderStatus());
        oldOrder.setPrice(dto.getPrice());
        oldOrder.setOrderStatus(dto.getOrderStatus());
        oldOrder.setCourier(mapperUser.toEntity(dto.getCourier()));

        orderRepository.save(oldOrder);
         return mapperOrder.toDto(oldOrder);
    }

    @Override
    public void delete(Long id) {
         orderRepository.delete(orderRepository.findAllById(id));
    }

    @Override
    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream().map(mapperOrder::toDto).collect(Collectors.toList());//List<Long> -> List<Order>
    }
}
