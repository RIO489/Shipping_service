package shippingService.service;

import shippingService.dto.HolidayDTO;
import shippingService.repository.HolidayRepository;

import java.util.List;

public interface HolidayService {
    HolidayDTO create(HolidayDTO holidayDTO);

    HolidayDTO update(HolidayDTO holidayDTO);

    void delete(Long id);

    HolidayDTO findById(Long id);

    List<HolidayDTO> getAll();
}
