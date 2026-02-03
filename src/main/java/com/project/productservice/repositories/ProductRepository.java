package com.project.productservice.repositories;

import com.project.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    
    List<Product> findAllByName(String name);

    List<Product> findAllByNameAndDescription(String name, String description);

    List<Product> findAllByName_OrderById(String name);
}
