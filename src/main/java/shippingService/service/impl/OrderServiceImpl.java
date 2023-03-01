package shippingService.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippingService.dto.OrderDTO;
import shippingService.entity.Order;
import shippingService.entity.Shop;
import shippingService.entity.User;
import shippingService.enums.OrderStatus;
import shippingService.exception.ServiceException;
import shippingService.mapper.OrderMapper;
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
    private OrderMapper orderMapper;
    @Autowired
    private MapperUser mapperUser;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShopRepository shopRepository;

    @Override
    public OrderDTO create(OrderDTO dto) throws ServiceException {
        log.info("Order for create: {}", dto);//ORDER!!!!!
        Order order = new Order();
        order.setOrderStatus(OrderStatus.PENDING);

        User courier = userRepository.findById(dto.getCourierId()).orElseThrow(() -> new ServiceException("Can`t find User by this ID: " + dto.getCourierId()));
        Shop shop = shopRepository.findById(dto.getShop().getId()).orElseThrow(() -> new ServiceException("Can`t find Shop by this ID: " + dto.getShop().getId()));

        order.setCourier(courier);
        order.setShop(shop);

        orderRepository.save(order);
        userRepository.save(courier);
        shopRepository.save(shop);
        log.info("Order created: {}", order);//Order!!!
        return orderMapper.toDto(order);
    }

    @Override
    public OrderDTO findOneById(Long id) {
        return orderMapper.toDto(orderRepository.findById(id).orElseThrow());
    }

    @Override
    public OrderDTO update(OrderDTO dto) throws ServiceException {
        Order oldOrder = orderRepository.findById(dto.getId()).stream().findFirst().orElseThrow();
        oldOrder.setAddress(dto.getAddress());
        if (!(oldOrder.getOrderStatus().name().equals("COMPLETED"))) {
            oldOrder.setOrderStatus(dto.getOrderStatus());
        }
        oldOrder.setPrice(dto.getPrice());
        oldOrder.setOrderStatus(dto.getOrderStatus());
        User courier = userRepository.findById(dto.getCourierId()).orElseThrow(() -> new ServiceException("Can`t find User by this ID: " + dto.getCourierId()));
        oldOrder.setCourier(courier);

        orderRepository.save(oldOrder);
        return orderMapper.toDto(oldOrder);
    }

    @Override
    public void delete(Long id) {
        if(orderRepository.findById(id).isPresent()) {
            orderRepository.delete(orderRepository.findById(id).get());
        }
    }

    @Override
    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream().map(orderMapper::toDto).collect(Collectors.toList());//List<Long> -> List<Order>
    }
}
