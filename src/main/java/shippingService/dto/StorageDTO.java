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
    private Long storage_id;
    @NotNull
    private ShopDTO shop_id;
    @NotNull
    private ProductDTO product_id;
    private Boolean available;
}
