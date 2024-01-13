package com.vaibhav2903.ecommerce_proj.repository;

import com.vaibhav2903.ecommerce_proj.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
