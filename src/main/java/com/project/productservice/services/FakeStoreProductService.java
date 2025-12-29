package com.project.productservice.services;

import com.project.productservice.dtos.FakeStoreProductDto;
import com.project.productservice.dtos.GenericProductDto;
import com.project.productservice.exceptions.ProductNotFoundException;
import com.project.productservice.thirdpartyclients.fakeStoreClient.FakeStoreClientAdapter;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private FakeStoreClientAdapter fakeStoreClientAdapter;

    FakeStoreProductService(FakeStoreClientAdapter fakeStoreClientAdapter) {
        this.fakeStoreClientAdapter = fakeStoreClientAdapter;
    }

    private static GenericProductDto convertoToGenericProductDto(FakeStoreProductDto fakeStoreProductDto)
    {

        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        return genericProductDto;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException{
        //Integrate the fake store API.
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
