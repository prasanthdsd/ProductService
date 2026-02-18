package com.project.productservice.security;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class JWTObject {

    //This is kind of DTO Object
    private String email;
    private Long user_id;
    private Date createdAt;
    private Date expiryAt;
    private List<Role> roles;
}
