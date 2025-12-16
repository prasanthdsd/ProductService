package com.project.productservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product extends BaseModel {

    private String description;
    private Category category;
    private BigDecimal price;
    private String image;
    private int rating;

}
