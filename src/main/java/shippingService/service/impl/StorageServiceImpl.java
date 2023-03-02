package shippingService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippingService.dto.ProductDTO;
import shippingService.dto.ShopDTO;
import shippingService.dto.StorageDTO;
import shippingService.entity.Storage;
import shippingService.exception.ServiceException;
import shippingService.mapper.StorageMapper;
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
    private ShopService shopService;

    @Autowired
    private ProductService productService;

    @Override
    public StorageDTO create(StorageDTO storageDTO) {
        Storage storage = storageMapper.toEntity(storageDTO);
        storageRepository.save(storage);
        return storageMapper.toDto(storage);
    }

    @Override
    public StorageDTO read(final Long id) {
        return storageMapper.toDto(storageRepository.findById(id).orElseThrow());
    }

    @Override
    public void update(StorageDTO dto) {
        Storage storage = storageMapper.toEntity(dto);
        storageRepository.save(storage);
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
    public void checkProduct(String shopName, String productName){
        final ShopDTO shopDTO = new ShopDTO();
        final ProductDTO productDTO = new ProductDTO();
        if(shopDTO.getShopName().equals(shopName)){
            if(productDTO.getName().equals(productName)){
                throw new ServiceException("Product is available");
            }
        }else{
            throw new ServiceException("No such shop or invalid shopName");
        }
    }
}
