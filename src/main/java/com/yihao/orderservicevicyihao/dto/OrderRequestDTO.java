package com.yihao.orderservicevicyihao.dto;

import lombok.Data;

@Data
public class OrderRequestDTO {

    private Long userId;

    private String productName;

    private Integer quantity;

    private Double price;

    private String status;
}