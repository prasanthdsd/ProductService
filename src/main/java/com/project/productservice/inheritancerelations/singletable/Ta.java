package com.project.productservice.inheritancerelations.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_ta")
@DiscriminatorValue(value = "3")
public class Ta extends User {
}
