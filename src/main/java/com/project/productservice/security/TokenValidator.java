package com.project.productservice.security;

import com.project.productservice.dtos.FakeStoreProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class TokenValidator {

    private RestTemplateBuilder restTemplateBuilder;

    private String userServiceUrl;

    TokenValidator(RestTemplateBuilder restTemplateBuilder, @Value("${userservice.validate.url}") String userServiceUrl) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.userServiceUrl = userServiceUrl;
    }
    /**
     * This method is used call the UserService and  validate the token.
     * If token is valid then return the corresponding Object else return empty
     * @param token
     * @return
     */
    public Optional<JWTObject> validateToken(String token){

        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestValidateObjectDto requestValidateObjectDto = new RequestValidateObjectDto();
        requestValidateObjectDto.setToken(token);
        requestValidateObjectDto.setUserId(1L);

        ResponseEntity<JWTObject> responseEntity = restTemplate.postForEntity(userServiceUrl,requestValidateObjectDto,JWTObject.class);

        //Make a call to User Service to call the validate token method
        JWTObject jwtObject = responseEntity.getBody();
        if(jwtObject == null){
            return Optional.empty();
        }
        return Optional.of(jwtObject);
    }
}
