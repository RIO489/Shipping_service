package shippingService.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shippingService.dto.ProductDTO;
import shippingService.entity.Product;
import shippingService.service.ProductService;
import shippingService.service.impl.ProductServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductResource {
    @Autowired
    private ProductService productService = new ProductServiceImpl();

    @PostMapping("/create")
    public String create(
            @Valid @RequestBody final ProductDTO productDTO) {
        productService.create(productDTO);
        return "all good";
    }

    @GetMapping("/{id}")
    public ProductDTO read(final @PathVariable Long id) {
        return productService.read(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(final @PathVariable("id") Long id, @RequestBody ProductDTO productDTO) {
        productService.update(productDTO, id);
        return ResponseEntity.ok(productDTO);

    }

    @DeleteMapping("/{id}")
    public String delete(final @PathVariable("id") Long id) {
        ProductDTO productDTO = productService.read(id);
        productService.delete(id);
        return "Product:" + productDTO.toString();

    }

    @GetMapping(value = "/all")
    public List<ProductDTO> getAll() {
        return productService.getAll();
    }

}
