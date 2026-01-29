package com.project.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String description;
    private String image;
    private int rating;
    //Category is not primitive it is relation
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Category category;

    @OneToOne(optional = false)
    @JoinColumn(nullable = false)
    private Price price;

}
