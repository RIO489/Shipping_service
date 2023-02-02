package shippingService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StorageDTO {

    @NotNull
    private BigInteger storageID;
    @NotNull
    private BigInteger shopID;
    @NotNull
    private BigInteger productID;
    private Boolean available;
}
