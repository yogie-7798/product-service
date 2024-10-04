package com.yog.productservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCreateRequestDto {

    private String productName;
    private String productDescription;
    private Double productPrice;
    private String productCategory;

}
