package shippingService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippingService.dto.ProductDTO;
import shippingService.entity.Product;
import shippingService.mapper.MapperProduct;
import shippingService.repository.ProductRepository;
import shippingService.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MapperProduct mapperProduct = new MapperProduct();

    @Override
    public ProductDTO create(ProductDTO productDTO){
        Product product = mapperProduct.toEntity(productDTO);
        productRepository.save(product);
        return mapperProduct.toDto(product);
    }

}
