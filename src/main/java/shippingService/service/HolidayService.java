package shippingService.service;

import shippingService.dto.HolidayDTO;
import shippingService.repository.HolidayRepository;

import java.util.List;

public interface HolidayService {
    void create(HolidayDTO holidayDTO);

    void update(HolidayDTO holidayDTO);

    void delete(Long id);

    HolidayDTO findById(Long id);

    List<HolidayDTO> getAll();
}
