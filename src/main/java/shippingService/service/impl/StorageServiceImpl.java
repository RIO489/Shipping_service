package shippingService.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import shippingService.dto.StorageDTO;
import shippingService.entity.Product;
import shippingService.entity.Storage;
import shippingService.mapper.StorageMapper;
import shippingService.repository.StorageRepository;
import shippingService.service.StorageService;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Service
@Transactional
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageMapper storageMapper;
    @Autowired
    private StorageRepository storageRepository;

    @Override
    public StorageDTO create(final @RequestBody StorageDTO dto) {
        storageRepository.add(dto);
        final Storage storageRepos = storageRepository.getStorages().get(storageRepository.getStorages().size() - 1);
        return storageMapper.toDto(storageRepos);
    }

    @Override
    public StorageDTO read(final BigInteger id) {
        return storageMapper.toDto(storageRepository.findById(id));
    }

    @Override
    public StorageDTO update(final StorageDTO dto) {
        storageRepository.update(dto.getStorageID(), dto);
        return storageMapper.toDto(storageRepository.findById(dto.getStorageID()));
    }

    @Override
    public StorageDTO delete(final BigInteger id) {
        final Storage storage = storageRepository.findById(id);
        storageRepository.delete(id);
        return storageMapper.toDto(storage);
    }
}
