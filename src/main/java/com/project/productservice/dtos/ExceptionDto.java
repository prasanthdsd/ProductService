package com.project.productservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
public class ExceptionDto {
    private HttpStatusCode httpStatusCode;
    private String message;
}
