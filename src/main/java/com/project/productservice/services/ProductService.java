package com.project.productservice.services;

import com.project.productservice.dtos.GenericProductDto;
import com.project.productservice.exceptions.ProductNotFoundException;

import java.util.List;
import java.util.UUID;


public interface ProductService {

    GenericProductDto getProductById(UUID id) throws ProductNotFoundException;

    List<GenericProductDto> getAllProducts() throws ProductNotFoundException;

    GenericProductDto deleteProductById(Long productId) ;

    GenericProductDto createProduct(GenericProductDto genericProductDto);

    GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto);
}
