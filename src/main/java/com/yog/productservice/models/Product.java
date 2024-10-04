package com.yog.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends BaseModel {

    private String name;
    private String description;
    private Double price;
    @ManyToOne
    private Category category;

}
