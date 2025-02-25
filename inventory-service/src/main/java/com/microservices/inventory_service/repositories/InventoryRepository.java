package com.microservices.inventory_service.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.inventory_service.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
List<Inventory> findBySkuCodeIn(List<String> skuCode);
Optional<Inventory> findBySkuCode(String skuCode);

}
