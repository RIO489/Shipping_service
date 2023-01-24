package shippingService.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shippingService.dto.ProductDTO;
import shippingService.entity.Product;
import shippingService.service.ProductService;
import shippingService.service.impl.ProductServiceImpl;

import javax.validation.Valid;

@RestController
@RequestMapping("api/product")
public class ProductResource {
    @Autowired
    private ProductService productService = new ProductServiceImpl();

    @PostMapping
    public String create(
            @Valid @RequestBody final ProductDTO productDTO){
        productService.create(productDTO);
        return "all good";
    }
}
