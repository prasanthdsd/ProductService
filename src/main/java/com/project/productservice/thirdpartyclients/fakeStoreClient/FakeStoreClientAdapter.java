package com.project.productservice.thirdpartyclients.fakeStoreClient;

import com.project.productservice.dtos.FakeStoreProductDto;
import com.project.productservice.dtos.GenericProductDto;
import com.project.productservice.exceptions.ProductNotFoundException;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreClientAdapter {

    private final RestTemplateBuilder restTemplateBuilder;


    private final String genericProductUrl = "https://fakestoreapi.com/products";
    private final String specificProductUrl = "https://fakestoreapi.com/products/{id}";

    FakeStoreClientAdapter(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }


    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException{
        //Integrate the fake store API.
        //Rest Templates
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        //covert FakeStoreProductDto to GenericProductDto
        if (fakeStoreProductDto == null) {
            //Exception Handling
            throw new ProductNotFoundException( "Product with id : "+ id +" doesn't exist");
        }
        return fakeStoreProductDto;

    }


    public List<FakeStoreProductDto> getAllProducts() throws ProductNotFoundException{

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity(genericProductUrl, FakeStoreProductDto[].class);

        if(responseEntity.getBody() == null) {
            throw new ProductNotFoundException( "No products found");
        };


        return Arrays.stream(responseEntity.getBody()).toList();
    }

    public FakeStoreProductDto deleteProductById(Long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return responseEntity.getBody();

    }

    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.postForEntity(genericProductUrl, genericProductDto, FakeStoreProductDto.class);

        return responseEntity.getBody();
    }

    public FakeStoreProductDto updateProductById(Long id, GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        return restTemplate.patchForObject(specificProductUrl, genericProductDto, FakeStoreProductDto.class,id);

    }
}
