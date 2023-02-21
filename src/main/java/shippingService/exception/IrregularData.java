package shippingService.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IrregularData extends Throwable{
    private int code;
    private String massage;

    public IrregularData(String massage){
        this.code = 400;
        this.massage = massage;
    }
    public IrregularData(){
        this.code = 400;
    }
}
