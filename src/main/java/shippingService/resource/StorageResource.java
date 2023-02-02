package shippingService.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shippingService.dto.StorageDTO;
import shippingService.service.StorageService;
import shippingService.service.impl.StorageServiceImpl;

import java.math.BigInteger;


@RestController
@RequestMapping("api/storage")
public class StorageResource {
    @Autowired
    private final StorageService storageService = new StorageServiceImpl();

    @PostMapping
    public StorageDTO create(final @Validated @RequestBody StorageDTO storageDTO) {
        return storageService.create(storageDTO);
    }

    @PutMapping
    public ResponseEntity<StorageDTO> put(final @Validated @RequestBody StorageDTO storageDTO) {
        return ResponseEntity.ok(storageService.update(storageDTO));
    }

    @GetMapping("/{id}")
    public StorageDTO get(final @PathVariable BigInteger id) {
        return storageService.read(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StorageDTO> delete(final @PathVariable BigInteger id) {
        final StorageDTO storageDTO = get(id);
        storageService.delete(id);
        return ResponseEntity.ok(storageDTO);
    }
}
