package com.project.productservice.services;

import com.project.productservice.dtos.FakeStoreProductDto;
import com.project.productservice.dtos.GenericProductDto;
import com.project.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service("selfProductService")
public class SelfProductService  implements ProductService{

    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public void getAllProducts() {

    }

    @Override
    public void deleteProductById(Long productId) {

    }

    @Override
    public void createProduct(Product product) {

    }

    @Override
    public void updateProductById(long productId) {

    }
}
