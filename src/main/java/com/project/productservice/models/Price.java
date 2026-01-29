package com.project.productservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Price extends BaseModel{

    private String currency;
    private BigDecimal value;

}
