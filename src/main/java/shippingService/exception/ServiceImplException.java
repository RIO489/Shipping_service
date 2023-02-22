package shippingService.exception;

import lombok.Data;

@Data
public class ServiceImplException extends Throwable {
    private int code;
    private String massage;

    public ServiceImplException(String massage) {
        this.code = 400;
        this.massage = massage;
    }

    public ServiceImplException() {
        this.code = 400;
    }

}