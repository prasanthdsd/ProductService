package com.project.productservice.models;

import com.project.productservice.dtos.GenericProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@ToString
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

    public GenericProductDto fromProduct(Product product) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setName(product.getName());
        genericProductDto.setDescription(product.getDescription());
        genericProductDto.setImage(product.getImage());
        return genericProductDto;
    }

}
