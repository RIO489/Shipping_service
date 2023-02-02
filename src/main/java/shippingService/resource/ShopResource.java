package shippingService.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shippingService.dto.ShopDTO;
import shippingService.service.ShopService;

import java.util.List;

@RestController
@RequestMapping("api/shop")
public class ShopResource {
    @Autowired
    private ShopService shopService;

    @PostMapping
    private ShopDTO create(final @RequestBody @Validated ShopDTO shopDTO){
        return shopService.create(shopDTO);
    }

    @PutMapping
    public ShopDTO put(final @RequestBody ShopDTO shopDTO) {
        return shopService.update(shopDTO);
    }

    @GetMapping("/{id}")
    public ShopDTO get(final @PathVariable long id) {
        return shopService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(final @PathVariable long id) {
        shopService.delete(id);
    }

    @GetMapping("/all")
    public List<ShopDTO> getAll() {
        return shopService.getAll();
    }

}
