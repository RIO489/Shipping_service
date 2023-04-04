package shippingService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippingService.dto.ProductDTO;
import shippingService.dto.ShopDTO;
import shippingService.dto.StorageDTO;
import shippingService.entity.Product;
import shippingService.entity.Shop;
import shippingService.entity.Storage;
import shippingService.exception.ServiceException;
import shippingService.mapper.StorageMapper;
import shippingService.repository.ProductRepository;
import shippingService.repository.ShopRepository;
import shippingService.repository.StorageRepository;
import shippingService.service.ProductService;
import shippingService.service.ShopService;
import shippingService.service.StorageService;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageMapper storageMapper;
    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShopService shopService;

    @Autowired
    private ProductService productService;

    @Override
    public StorageDTO read(final Long id) {
        return storageMapper.toDto(storageRepository.findById(id).orElseThrow());
    }

    @Override
    public void delete(final Long id) {
        storageRepository.delete(storageRepository.findById(id).orElseThrow());
    }

    @Override
    public List<StorageDTO> getAll() {
        return storageRepository.findAll().stream().map(storageMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public boolean checkProduct(String shopName, String productName) {
        return true;
    }

    /*@Override
    public boolean deactivate(Long storageId) {
    }*/

    @Override
    public boolean activate(Long storageId) {
        final Storage storage = new Storage();
        if (storageRepository.findAll()
                .stream()
                .anyMatch(e -> e.getStorageId() == storageId)) {
            return true;
        } else return false;
    }

    /*@Override
    public boolean deactivate(Long shopId, Long productId) {

    }*/

    @Override
    public boolean activate(Long shopId, Long productId) {
        final Shop shop = new Shop();
        final Product product = new Product();
        if (shopRepository.findAll()
                .stream()
                .anyMatch(e -> e.getId() == shopId) && productRepository.findAll()
                .stream()
                .anyMatch(e -> e.getId() == productId)){
            return true;
        }
        else return false;
    }
}
