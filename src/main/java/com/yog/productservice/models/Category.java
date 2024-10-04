package com.yog.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category extends BaseModel {

    private String categoryName;
    private String categoryDescription;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
