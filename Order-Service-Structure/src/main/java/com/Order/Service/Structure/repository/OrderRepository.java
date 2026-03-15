package com.Order.Service.Structure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Order.Service.Structure.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}