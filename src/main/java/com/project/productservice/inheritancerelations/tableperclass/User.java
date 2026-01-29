package com.project.productservice.inheritancerelations.tableperclass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "tpc_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;

}
