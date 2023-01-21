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


    @Override
    public Product create(Product product){
        return productRepository.save(product);
    }

}
