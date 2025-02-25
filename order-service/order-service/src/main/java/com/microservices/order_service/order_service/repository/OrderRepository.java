package com.microservices.order_service.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.order_service.order_service.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
