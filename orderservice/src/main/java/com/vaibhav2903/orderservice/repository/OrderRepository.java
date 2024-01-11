package com.vaibhav2903.orderservice.repository;

import com.vaibhav2903.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
