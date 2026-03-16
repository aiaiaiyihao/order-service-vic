package com.yihao.orderservicevicyihao.service;

import com.yihao.orderservicevicyihao.entity.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(Order order);

    Order getOrderById(Long id);

    List<Order> getAllOrders();

    Order updateOrder(Long id, Order updatedOrder);

    void deleteOrder(Long id);
}
