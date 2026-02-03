package com.project.productservice.services;

import com.project.productservice.dtos.GenericProductDto;
import com.project.productservice.exceptions.ProductNotFoundException;
import com.project.productservice.models.Product;
import com.project.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("SelfProductService")
@Primary
public class SelfProductService implements ProductService {

    private  ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public GenericProductDto getProductById(UUID id) throws ProductNotFoundException {
        GenericProductDto genericProductDto = new GenericProductDto();
        Optional<Product> optionalProduct = productRepository.findProductById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            genericProductDto.setName(product.getName());
            genericProductDto.setDescription(product.getDescription());
            genericProductDto.setCategory(product.getCategory().toString());
            genericProductDto.setImage(product.getImage());
            genericProductDto.setPrice(product.getPrice().getValue().intValue());
            return genericProductDto;

        }
        return null;

    }

    @Override
    public List<GenericProductDto> getAllProducts() throws ProductNotFoundException {
        return List.of();
    }

    @Override
    public GenericProductDto deleteProductById(Long productId) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto) {
        return null;
    }
}
