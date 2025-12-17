package com.project.productservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FakeStoreProductDto {

    private Long id;
    private String title;
    private int price;
    private String category;
    private String description;
    private String image;

}
