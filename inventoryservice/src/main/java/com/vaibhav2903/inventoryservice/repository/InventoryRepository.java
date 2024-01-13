package com.vaibhav2903.inventoryservice.repository;

import com.vaibhav2903.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    public Optional<Inventory> findBySkuCode(String skuCode);
}
