package com.project.shopapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.shopapp.models.Oders.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Tìm các đơn hàng của 1 user nào đó
    List<Order> findByUserId(Long userId);
}
