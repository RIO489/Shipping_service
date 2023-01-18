package shippingService.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippingService.dto.ProductDTO;
import shippingService.entity.Product;
import shippingService.mapper.ProductMapper;
import shippingService.repository.ProductRepository;
import shippingService.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.getAllProducts().stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO create(final ProductDTO productDTO) {
        final Product product = productMapper.toEntity(productDTO);
        productRepository.save(product);
        return productMapper.toDTO(product);
    }

    @Override
    public ProductDTO findById(final Long id) {
        return productMapper.toDTO(productRepository.findById(id));
    }

    @Override
    public ProductDTO update(final ProductDTO productDTO) {
        final Product product = productMapper.toEntity(productDTO);

        productRepository.update(product);

        return productMapper.toDTO(product);
    }

    @Override
    public void delete(final Long id) {
        productRepository.delete(id);
    }
}
