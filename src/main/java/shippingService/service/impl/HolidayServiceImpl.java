package shippingService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shippingService.dto.HolidayDTO;
import shippingService.mapper.MapperHoliday;
import shippingService.repository.HolidayRepository;
import shippingService.service.HolidayService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class HolidayServiceImpl implements HolidayService {

    @Autowired
    HolidayRepository holidayRepository;

    @Override
    public HolidayDTO create(HolidayDTO holidayDTO) {
        holidayRepository.save(MapperHoliday.ToEntity(holidayDTO));
        return holidayDTO;
    }

    @Override
    @Transactional
    public HolidayDTO update(HolidayDTO holidayDTO) {
        delete(holidayDTO.getId());
        create(holidayDTO);
        return holidayDTO;
    }

    @Override
    public void delete(Long id) {
        holidayRepository.deleteById(id);
    }

    @Override
    public HolidayDTO findById(Long id) {
        try{
            return MapperHoliday.ToDTO(holidayRepository.findById(id).get());
        }catch (NoSuchElementException ex){
            return null;
        }
    }

    @Override
    public List<HolidayDTO> getAll() {
        return holidayRepository.findAll().stream()
                .map(MapperHoliday::ToDTO)
                .collect(Collectors.toList());
    }
}
