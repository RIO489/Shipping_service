package shippingService.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shippingService.dto.HolidayDTO;
import shippingService.service.HolidayService;

import java.util.List;

@RestController
@RequestMapping("api/holiday")
public class HolidayResource {
    @Autowired
    private HolidayService holidayService;

    @PostMapping("/create")
    public void create(@RequestBody HolidayDTO holidayDTO){
        holidayService.create(holidayDTO);
    }

    @PutMapping("/update")
    public void update(@RequestBody HolidayDTO holidayDTO){

    }

    @GetMapping("/{id}")
    public HolidayDTO get(@PathVariable Long id){
        return holidayService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        holidayService.delete(id);
    }

    @GetMapping("/all")
    public List<HolidayDTO> getAll(){
        return holidayService.getAll();
    }
}
