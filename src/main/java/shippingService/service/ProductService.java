package shippingService.service;

import shippingService.dto.ProductDTO;
import shippingService.entity.Product;

import java.util.List;

public interface ProductService  {
    ProductDTO create(ProductDTO productDTO);

    ProductDTO read(Long id);

    ProductDTO update(ProductDTO dto, Long id);

    void delete(Long id);

    List<ProductDTO> getAll();

}
