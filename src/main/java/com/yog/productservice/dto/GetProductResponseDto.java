package com.yog.productservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductResponseDto {

    private Long productId;
    private String productName;
    private String productDescription;
    private Double productPrice;

}
