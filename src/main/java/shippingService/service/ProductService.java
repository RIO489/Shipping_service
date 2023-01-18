package shippingService.service;

import shippingService.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO create(ProductDTO productDTO);
    ProductDTO findById(Long id);
    ProductDTO update(ProductDTO productDTO);
    void delete(Long id);

}
