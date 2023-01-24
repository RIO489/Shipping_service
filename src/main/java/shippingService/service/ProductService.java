package shippingService.service;

import shippingService.dto.ProductDTO;
import shippingService.entity.Product;

import java.util.List;

public interface ProductService  {
    ProductDTO create(ProductDTO productDTO);
/*
    ProductDTO read(Long id);

    ProductDTO update(ProductDTO dto);

    ProductDTO delete(Long id);

    List<ProductDTO> getAll();
*/
}
