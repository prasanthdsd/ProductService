package com.project.productservice.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestValidateObjectDto {
    private Long userId;
    private String token;
}
