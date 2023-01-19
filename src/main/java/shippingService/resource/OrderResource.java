package shippingService.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shippingService.dto.OrderDTO;
import shippingService.service.OrderService;
import shippingService.service.impl.OrderServiceImpl;

import java.util.List;


@RestController
@RequestMapping({"api/order"})
public class OrderResource {

    private final OrderService orderService = new OrderServiceImpl();

    @PostMapping
    public OrderDTO create(final  @RequestBody OrderDTO orderDTO) {
        orderService.create(orderDTO);
        return orderDTO;
    }
    @PutMapping
    public ResponseEntity<OrderDTO> put(final  @RequestBody OrderDTO orderDTO) {
        orderService.update(orderDTO);
        return ResponseEntity.ok(orderDTO);
    }

    @GetMapping("/{id}")
    public OrderDTO get(final @PathVariable Long id) {
        return orderService.read(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDTO> delete(final @PathVariable Long id) {
        final OrderDTO orderDTO = get(id);
        orderService.delete(id);
        return ResponseEntity.ok(orderDTO);
    }

    @GetMapping(value = "/all")
    public List<OrderDTO> getAll() {
        return orderService.getAll();
    }



}
