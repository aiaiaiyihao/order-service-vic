package com.yihao.orderservicevicyihao.repository;

import com.yihao.orderservicevicyihao.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByStatus(String status);
}
