package shippingService.service;

import shippingService.dto.ProductDTO;


import java.util.List;

public interface ProductService {
    ProductDTO create(ProductDTO productDTO);

    ProductDTO read(Long id);

    void update(ProductDTO dto);

    void delete(Long id);

    List<ProductDTO> getAll();

}
