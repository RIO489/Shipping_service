package shippingService.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Getter
@Setter
public class ServiceException extends RuntimeException {
    private int code;
    private String message;
    private String details;

    public ServiceException(final int code, final String message) {
        this(code, message, "");
    }

    public ServiceException(final String message, final String details) {
        this(HttpStatus.BAD_REQUEST.value(), message, details);
    }

    public ServiceException(final String message) {
        this(HttpStatus.BAD_REQUEST.value(), message);
    }
}