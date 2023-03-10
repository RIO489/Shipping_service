package shippingService.mapper;

import org.springframework.stereotype.Component;
import shippingService.dto.HolidayDTO;
import shippingService.entity.Holiday;

@Component
public class HolidayMapper {
    public HolidayDTO toDTO(Holiday holiday){
        final HolidayDTO holidayDTO = new HolidayDTO();

        holidayDTO.setId(holiday.getId());
        holidayDTO.setShop(holiday.getShop());
        holidayDTO.setTimeOpen(holiday.getTimeOpen());
        holidayDTO.setTimeClose(holiday.getTimeClose());
        holidayDTO.setTitle(holiday.getTitle());

        return holidayDTO;
    }

    public Holiday toEntity(HolidayDTO holidayDTO){
        final Holiday holiday = new Holiday();

        holiday.setId(holidayDTO.getId());
        holiday.setShop(holidayDTO.getShop());
        holiday.setTimeOpen(holidayDTO.getTimeOpen());
        holiday.setTimeClose(holidayDTO.getTimeClose());
        holiday.setTitle(holidayDTO.getTitle());

        return holiday;
    }

}
