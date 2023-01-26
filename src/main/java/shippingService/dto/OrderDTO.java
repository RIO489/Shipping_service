package shippingService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shippingService.entity.Order;
import shippingService.enums.OrderStatus;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class OrderDTO {
        private Long id;
        private User courier;
        private User customer;
        private OrderStatus orderStatus;
        private Shop shop;
        private String address;
        private BigDecimal price;
    }