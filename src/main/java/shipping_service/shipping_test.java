package shipping_service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
public class shipping_test {

    @RequestMapping("/super")
    String home(){
        return "Hello world";
    }

}
