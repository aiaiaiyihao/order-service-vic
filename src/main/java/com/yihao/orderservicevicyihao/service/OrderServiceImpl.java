package com.yihao.orderservicevicyihao.service;

import com.yihao.orderservicevicyihao.dto.OrderRequestDTO;
import com.yihao.orderservicevicyihao.dto.OrderResponseDTO;
import com.yihao.orderservicevicyihao.entity.Order;
import com.yihao.orderservicevicyihao.exception.OrderNotFoundException;
import com.yihao.orderservicevicyihao.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
        Order order = modelMapper.map(orderRequestDTO, Order.class);

        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());

        Order savedOrder = orderRepository.save(order);
        log.info("Order created successfully with id: {}", savedOrder.getId());

        return modelMapper.map(savedOrder, OrderResponseDTO.class);
    }

    @Override
    public OrderResponseDTO getOrderById(Long id) {
        log.info("Fetching order with id: {}", id);

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));

        return modelMapper.map(order, OrderResponseDTO.class);
    }

    @Override
    public List<OrderResponseDTO> getAllOrders() {
        log.info("Fetching all orders");

        return orderRepository.findAll()
                .stream()
                .map(order -> modelMapper.map(order, OrderResponseDTO.class))
                .toList();
    }

    @Override
    public OrderResponseDTO updateOrder(Long id, OrderRequestDTO orderRequestDTO) {
        log.info("Updating order with id: {}", id);

        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));

        existingOrder.setUserId(orderRequestDTO.getUserId());
        existingOrder.setProductName(orderRequestDTO.getProductName());
        existingOrder.setQuantity(orderRequestDTO.getQuantity());
        existingOrder.setPrice(orderRequestDTO.getPrice());
        existingOrder.setStatus(orderRequestDTO.getStatus());
        existingOrder.setUpdatedAt(LocalDateTime.now());

        Order savedOrder = orderRepository.save(existingOrder);

        return modelMapper.map(savedOrder, OrderResponseDTO.class);
    }

    @Override
    public void deleteOrder(Long id) {
        log.info("Deleting order with id: {}", id);

        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));

        orderRepository.delete(existingOrder);
    }
}