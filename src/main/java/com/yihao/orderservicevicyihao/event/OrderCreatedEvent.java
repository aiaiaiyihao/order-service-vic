package com.yihao.orderservicevicyihao.event;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderCreatedEvent {
    private Long orderId;
    private Long userId;
    private String productName;
    private Integer quantity;
    private Double price;
    private String status;
    private LocalDateTime createdAt;
}
