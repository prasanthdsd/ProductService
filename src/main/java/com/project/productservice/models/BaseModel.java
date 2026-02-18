package com.project.productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {

    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    @Column(name= "id", columnDefinition = "binary(16)", nullable = false, updatable = false)
    private Long id;
    private String name;

}
