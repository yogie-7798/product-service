package com.yog.productservice.util;

import com.yog.productservice.dto.GetProductResponseDto;
import com.yog.productservice.dto.ProductCreateRequestDto;
import com.yog.productservice.dto.ProductCreateResponseDto;
import com.yog.productservice.models.Category;
import com.yog.productservice.models.Product;
import org.springframework.util.StringUtils;

public class CommonUtils {

    public static GetProductResponseDto getProductResponseDto(Product product) {
        if (product == null) {
            return null;
        }
        GetProductResponseDto getProductResponseDto = new GetProductResponseDto();
        getProductResponseDto.setProductId(product.getId());
        getProductResponseDto.setProductName(product.getName());
        getProductResponseDto.setProductDescription(product.getDescription());
        getProductResponseDto.setProductPrice(product.getPrice());
        return getProductResponseDto;
    }

    public static Product createProductReqDto(ProductCreateRequestDto createRequestDto) {
        if (createRequestDto != null) {
            Product product = new Product();
            product.setName(createRequestDto.getProductName());
            product.setDescription(createRequestDto.getProductDescription());
            product.setPrice(createRequestDto.getProductPrice());
            if (StringUtils.hasText(createRequestDto.getProductCategory())) {
                Category category = new Category();
                category.setCategoryName(createRequestDto.getProductCategory());
                product.setCategory(category);
            }
            return product;
        }
        return null;
    }

    public static ProductCreateResponseDto createProductResponseDto(Product product) {
        if (product != null) {
            ProductCreateResponseDto productCreateResponseDto = new ProductCreateResponseDto();
            productCreateResponseDto.setProductId(product.getId());
            productCreateResponseDto.setProductName(product.getName());
            productCreateResponseDto.setProductDescription(product.getDescription());
            productCreateResponseDto.setProductPrice(product.getPrice());
            productCreateResponseDto.setProductCategory(product.getCategory().getCategoryName());
            return productCreateResponseDto;
        }
        return null;
    }
}
