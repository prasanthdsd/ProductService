package com.project.productservice.dtos;

import com.project.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    private Long id;
    private String name;
    private int price;
    private String category;
    private String description;
    private String image;
}
