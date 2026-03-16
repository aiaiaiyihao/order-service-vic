package com.yihao.orderservicevicyihao.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderResponseDTO {

    private Long id;

    private Long userId;

    private String productName;

    private Integer quantity;

    private Double price;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}