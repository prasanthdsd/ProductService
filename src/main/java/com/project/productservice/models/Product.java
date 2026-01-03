package com.project.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String description;
    private BigDecimal price;
    private String image;
    private int rating;
    //Category is not primitive it is relation
    @ManyToOne
    private Category category;

}
