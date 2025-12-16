package com.project.productservice.services;

import com.project.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {


    @Override
    public String getProductById(Long id) {
        //Integrate the fake store API.

        return "product from service of id : "+id;
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
