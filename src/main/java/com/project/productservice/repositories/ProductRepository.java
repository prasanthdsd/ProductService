package com.project.productservice.repositories;

import com.project.productservice.models.Category;
import com.project.productservice.models.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    
    List<Product> findAllByName(String name, Pageable pageable);

    List<Product> findAllByNameAndDescription(String name, String description);

    List<Product> findAllByName_OrderById(String name);

    Optional<Product> findProductById(Long id);

    List<Product> findAllByCategory(Category category);
}
