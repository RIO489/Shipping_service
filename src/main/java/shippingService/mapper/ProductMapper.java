package shippingService.mapper;


import shippingService.dto.ProductDTO;
import shippingService.entity.Product;

public class ProductMapper {
    public ProductDTO toDTO(final Product product){
        final ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());

        return productDTO;
    }

    public Product toEntity(final ProductDTO productDTO){
        final Product product = new Product();

        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());

        return product;
    }
}
