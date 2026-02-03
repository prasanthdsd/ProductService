package com.project.productservice.controllers;

import com.project.productservice.dtos.GenericProductDto;
import com.project.productservice.exceptions.ProductNotFoundException;
import com.project.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {


    private ProductService productService;

    //constructor Injection
    //@Autowired OPTIONAL
    //@Qualifier("fakeStoreProductService")
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") UUID id) throws ProductNotFoundException {

        return productService.getProductById(id);
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts()  throws ProductNotFoundException{
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id) {
        return productService.deleteProductById(id);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto) {
        return productService.createProduct(genericProductDto);
    }

    @PutMapping("/{id}")
    public GenericProductDto updateProductById(@PathVariable("id") Long id, @RequestBody GenericProductDto genericProductDto) {
        return productService.updateProductById(id,genericProductDto);
    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage(productNotFoundException.getMessage());
//        exceptionDto.setHttpStatusCode(HttpStatusCode.valueOf(404));
//        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
//    }
}



/*
Three ways of dependency Injection

1. Constructor Injection :
2. Field Injection :
3. Setter Injection :

 */
