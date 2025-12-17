package com.project.productservice.services;

import com.project.productservice.dtos.FakeStoreProductDto;
import com.project.productservice.dtos.GenericProductDto;
import com.project.productservice.models.Product;
import org.springframework.stereotype.Service;


public interface ProductService {

    GenericProductDto getProductById(Long id);

    void getAllProducts();

    void deleteProductById(Long productId) ;

    void createProduct(Product product);

    void updateProductById(long productId);
}
