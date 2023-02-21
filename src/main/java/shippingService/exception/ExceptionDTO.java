package shippingService.exception;


import lombok.Data;

@Data
public class ExceptionDTO {
    private int code;
    private String massage;

    public ExceptionDTO(String massage){
        this.code = 400;
        this.massage = massage;
    }
    public ExceptionDTO(){
        this.code = 400;
    }
}
