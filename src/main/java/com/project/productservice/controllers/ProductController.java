package com.project.productservice.controllers;

import com.project.productservice.models.Product;
import com.project.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {


    private ProductService productService;

    //constructor Injection
    //@Autowired OPTIONAL
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id) {

        return productService.getProductById(id);
    }

    @GetMapping
    public void getAllProducts() {}

    @DeleteMapping("/{id}")
    public void deleteProductById(Long productId) {}

    public void createProduct(Product product) {}

    @PutMapping("/{id}")
    public void updateProductById(long productId) {}



}



/*
Three ways of dependency Injection

1. Constructor Injection :
2. Field Injection :
3. Setter Injection :

 */
