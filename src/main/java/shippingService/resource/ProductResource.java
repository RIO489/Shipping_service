package shippingService.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shippingService.dto.ProductDTO;
import shippingService.entity.Product;
import shippingService.service.ProductService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/product")
public class ProductResource {
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product create(
            @Valid @RequestBody final Product product){
        return productService.create(product);
    }
}
