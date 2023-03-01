package shippingService.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shippingService.dto.OrderDTO;
import shippingService.exception.ServiceException;
import shippingService.service.OrderService;

import java.util.List;


@RestController
@RequestMapping("api/order")
public class OrderResource {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderDTO create(final @RequestBody OrderDTO orderDTO) throws ServiceException {
        return orderService.create(orderDTO);
    }

    @PutMapping
    public OrderDTO put(final @RequestBody OrderDTO orderDTO) throws ServiceException {
        return orderService.update(orderDTO);
    }

    @GetMapping("/{id}")
    public OrderDTO get(final @PathVariable Long id) {
        return orderService.findOneById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(final @PathVariable Long id) {
        orderService.delete(id);
    }
}
