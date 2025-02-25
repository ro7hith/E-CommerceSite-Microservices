package com.microservices.product_services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.product_services.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
