package shippingService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shippingService.entity.Shop;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StorageDTO {

    @NotNull
    private Long storageId;
    @NotNull
    private ShopDTO shopId;
    @NotNull
    private ProductDTO productId;
    private Boolean available;
}
