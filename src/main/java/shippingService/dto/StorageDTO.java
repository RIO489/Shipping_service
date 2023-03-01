package shippingService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "storage")
public class StorageDTO {

    @NotNull
    private Long storageID;
    @NotNull
    private BigInteger shopID;
    @NotNull
    private BigInteger productID;
    private Boolean available;
}
