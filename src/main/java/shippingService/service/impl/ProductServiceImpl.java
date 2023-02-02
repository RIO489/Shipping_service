package shippingService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippingService.dto.ProductDTO;
import shippingService.entity.Product;
import shippingService.mapper.MapperProduct;
import shippingService.repository.ProductRepository;
import shippingService.service.ProductService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MapperProduct mapperProduct = new MapperProduct();

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        Product product = mapperProduct.toEntity(productDTO);
        productRepository.save(product);
        return mapperProduct.toDto(product);
    }

    @Override
    public ProductDTO read(Long id) {
        return mapperProduct.toDto(productRepository.findById(id).orElseThrow());
    }

    @Override
    public void update(ProductDTO dto) {
        productRepository.save(mapperProduct.toEntity(dto));
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(productRepository.findById(id).orElseThrow());
    }

    @Override
    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream().map(mapperProduct::toDto).collect(Collectors.toList());
    }
}
