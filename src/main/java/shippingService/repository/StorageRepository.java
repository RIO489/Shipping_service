package shippingService.repository;

import org.springframework.stereotype.Repository;
import shippingService.dto.StorageDTO;
import shippingService.entity.Storage;
import shippingService.exception.ServiceException;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StorageRepository {
    List<Storage> storages = new ArrayList<>();
    public void setStorages(final List<Storage> accounts) {
        this.storages = accounts;
    }

    public List<Storage> getStorages() {
        return storages;
    }
    public void add(final StorageDTO dto) {
        final Storage finalStorage = new Storage();
        finalStorage.setStorageID(dto.getStorageID());
        finalStorage.setShopID(dto.getShopID());
        finalStorage.setProductID(dto.getProductID());
        storages.add(finalStorage);
    }

    public Storage findById(final BigInteger id) {
        return storages.stream().filter(e -> e.getStorageID().equals(id)).findFirst()
                .orElseThrow(() -> new ServiceException("No such id"));
    }

    public void update(final BigInteger id, final StorageDTO dto) {
        final Storage update = findById(id);
        update.setStorageID(dto.getStorageID());
        update.setShopID(dto.getShopID());
        update.setProductID(dto.getProductID());
    }

    public void delete(final BigInteger id) {
        setStorages(storages.stream().filter(e -> !e.getStorageID().equals(id)).collect(Collectors.toList()));
    }
}
