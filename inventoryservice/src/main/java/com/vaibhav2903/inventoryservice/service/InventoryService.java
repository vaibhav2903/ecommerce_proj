package com.vaibhav2903.inventoryservice.service;

import com.vaibhav2903.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    public final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean inStock(String skuCode){
       return inventoryRepository.findBySkuCode(skuCode).isPresent();

    }
}
