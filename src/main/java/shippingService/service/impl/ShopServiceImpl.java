package shippingService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shippingService.dto.ShopDTO;
import shippingService.entity.Shop;
import shippingService.exception.IrregularData;
import shippingService.mapper.MapperShop;
import shippingService.repository.ShopRepository;
import shippingService.service.ShopService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopRepository shopRepository;

    @Override
    public ShopDTO create(ShopDTO shopDTO) {
        shopRepository.save(MapperShop.ToEntity(shopDTO));
        return shopDTO;
    }

    @Override
    public void delete(long id) {
        shopRepository.deleteById(id);
    }

    @Override
    @Transactional
    public ShopDTO update(ShopDTO shopDTO) {
//        Shop shop = shopRepository.findById(shopDTO.getId()).get();
        delete(shopDTO.getId());
        create(shopDTO);

        shopRepository.save(MapperShop.ToEntity(shopDTO));
        //save
        //todo
        return findById(shopDTO.getId());
    }

    @Override
    public List<ShopDTO> getAll() {
        return shopRepository.findAll().stream()
                .map(MapperShop::ToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ShopDTO findById(long id) {
//        if(!shopRepository.findById(id).isPresent()){
//            throw new IrregularData("Shop with Id "+id+" not found.");
//        }
//        return shopRepository.findById(id).get();
        try {
            return MapperShop.ToDTO(shopRepository.findById(id).get());
        }catch (NoSuchElementException ex){
            return null;
        }
    }
}
