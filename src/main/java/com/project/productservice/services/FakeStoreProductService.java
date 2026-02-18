package com.project.productservice.services;

import com.project.productservice.dtos.FakeStoreProductDto;
import com.project.productservice.dtos.GenericProductDto;
import com.project.productservice.exceptions.ProductNotFoundException;
import com.project.productservice.security.JWTObject;
import com.project.productservice.security.TokenValidator;
import com.project.productservice.thirdpartyclients.fakeStoreClient.FakeStoreClientAdapter;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("fakeStoreProductService")
@Primary
public class FakeStoreProductService implements ProductService {

    private FakeStoreClientAdapter fakeStoreClientAdapter;

    private TokenValidator tokenValidator;

    FakeStoreProductService(FakeStoreClientAdapter fakeStoreClientAdapter, TokenValidator tokenValidator) {
        this.fakeStoreClientAdapter = fakeStoreClientAdapter;
        this.tokenValidator = tokenValidator;
    }

    private static GenericProductDto convertoToGenericProductDto(FakeStoreProductDto fakeStoreProductDto)
    {

        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setName(fakeStoreProductDto.getTitle());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        return genericProductDto;
    }

    @Override
    public GenericProductDto getProductById(String authToken,Long id) throws ProductNotFoundException{
        //Integrate the fake store API.

        Optional<JWTObject> jwtObjectOptional = tokenValidator.validateToken(authToken);
        if(jwtObjectOptional.isEmpty()) {
            //Invalid Token
            //Reject request
            return null;

        }
        JWTObject jwtObject = jwtObjectOptional.get();
        Long userId = jwtObject.getUser_id();

        if(userId.equals(10L)) {
            return null;
        }

        System.out.println(jwtObject.toString());

        return convertoToGenericProductDto(fakeStoreClientAdapter.getProductById(id));

    }

    @Override
    public List<GenericProductDto> getAllProducts() throws ProductNotFoundException {

        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreClientAdapter.getAllProducts();

        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            genericProductDtos.add(convertoToGenericProductDto(fakeStoreProductDto));
        }
        return genericProductDtos;

    }

    @Override
    public GenericProductDto deleteProductById(Long id) {

        return convertoToGenericProductDto(fakeStoreClientAdapter.deleteProductById(id));

    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return convertoToGenericProductDto(fakeStoreClientAdapter.createProduct(genericProductDto));
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto) {
        return convertoToGenericProductDto(fakeStoreClientAdapter.updateProductById(id, genericProductDto));
    }
}
