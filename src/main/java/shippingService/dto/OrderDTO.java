package shippingService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shippingService.entity.Order;
import shippingService.enums.OrderStatus;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class OrderDTO {
        private Long id;
        @NotNull
        private Long courierId;
        @NotNull
        private UserDTO customer;
        @NotNull
        private OrderStatus orderStatus;
        @NotNull
        private ShopDTO shop;
        @NotNull
        private String address;
        @NotNull
        @Positive
        private BigDecimal price;
    }