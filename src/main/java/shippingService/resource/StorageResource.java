package shippingService.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shippingService.dto.ProductDTO;
import shippingService.dto.ShopDTO;
import shippingService.dto.StorageDTO;
import shippingService.dto.UserDTO;
import shippingService.service.StorageService;
import shippingService.service.impl.StorageServiceImpl;

import java.math.BigInteger;
import java.util.List;


@RestController
@RequestMapping("api/storage")
public class StorageResource {
    @Autowired
    private StorageService storageService;

    @PostMapping("/create")
    public StorageDTO create(final @Validated @RequestBody StorageDTO storageDTO) {
        return storageService.create(storageDTO);
    }
    @GetMapping("/{id}")
    public StorageDTO read(final @PathVariable Long id) {
        return storageService.read(id);
    }

    @GetMapping("/{id}")
    public StorageDTO get(final @PathVariable Long id) {
        return storageService.read(id);
    }

    @DeleteMapping("/{id}")
    public String delete(final @PathVariable("id") Long id) {
        StorageDTO storageDTO = storageService.read(id);
        storageService.delete(id);
        return "Storage:" + storageDTO.toString();
    }
    @GetMapping(value = "/all")
    public List<StorageDTO> getAll() {
        return storageService.getAll();
    }
}
