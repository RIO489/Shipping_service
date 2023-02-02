package shippingService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private BigInteger storageID;
    private BigInteger shopID;
    private BigInteger productID;
    private Boolean available;
}
