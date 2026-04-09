package com.project.productservice.services;

import com.project.productservice.dtos.GenericProductDto;
import com.project.productservice.dtos.SearchRequestDto;
import com.project.productservice.models.Product;
import com.project.productservice.models.SortParam;
import com.project.productservice.repositories.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    private ProductRepository productRepository;

    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<GenericProductDto> searchProducts(String query, int pageNumber, int pageSize, List<SortParam> sortParams) {

        Sort sort=Sort.by(sortParams.get(0).getSortDirection(), sortParams.get(0).getSortType());

        for(int i=0;i<sortParams.size();i++){
            sort = sort.and(Sort.by(sortParams.get(i).getSortDirection(), sortParams.get(i).getSortType()));
        }

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize,sort);

        List<Product> products = productRepository.findAllByName(query, pageRequest);
        List<GenericProductDto> genericProductDtos = new ArrayList<>();

        for (Product product : products) {
            genericProductDtos.add(product.fromProduct(product));
        }
        return genericProductDtos;
    }
}
