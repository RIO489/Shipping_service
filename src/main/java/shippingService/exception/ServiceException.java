package shippingService.exception;

import lombok.Data;

@Data
public class ServiceException extends Exception {
    private int code;
    private String message;

    public ServiceException(String message) {
        this.code = 400;
        this.message = message;
    }
}
