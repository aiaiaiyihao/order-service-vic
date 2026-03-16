package com.yihao.orderservicevicyihao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String productName;
    private Integer quantity;
    private Double price;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}