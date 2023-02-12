package shippingService.mapper;


import org.springframework.stereotype.Component;
import shippingService.dto.ProductDTO;
import shippingService.entity.Product;

@Component
public class MapperProduct {

    public ProductDTO toDto(final Product product) {
        final ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        return dto;
    }

    public Product toEntity(final ProductDTO dto) {
        final Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        return product;
    }
}
