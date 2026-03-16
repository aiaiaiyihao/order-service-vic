package com.yihao.orderservicevicyihao.service;

import com.yihao.orderservicevicyihao.dto.OrderRequestDTO;
import com.yihao.orderservicevicyihao.dto.OrderResponseDTO;

import java.util.List;

public interface OrderService {

    OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO getOrderById(Long id);

    List<OrderResponseDTO> getAllOrders();

    OrderResponseDTO updateOrder(Long id, OrderRequestDTO orderRequestDTO);

    void deleteOrder(Long id);
}