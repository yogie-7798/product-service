package com.yog.productservice.controller;

import com.yog.productservice.dto.GetProductResponseDto;
import com.yog.productservice.dto.ProductCreateRequestDto;
import com.yog.productservice.dto.ProductCreateResponseDto;
import com.yog.productservice.models.Product;
import com.yog.productservice.service.ProductService;
import com.yog.productservice.util.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public GetProductResponseDto getProduct(@PathVariable("id") Long id){
        GetProductResponseDto responseDto = new GetProductResponseDto();
        Product product = productService.getProduct(id);
        if (product != null) {
            return CommonUtils.getProductResponseDto(product);
        }
        return responseDto;
    }

    @PostMapping("/")
    public List<ProductCreateResponseDto> createProduct(@RequestBody List<ProductCreateRequestDto> requestDto){
        List<Product> createRequestProducts = requestDto.stream().map(CommonUtils::createProductReqDto).filter(Objects::nonNull).toList();
        List<Product> createdProducts = productService.createProduct(createRequestProducts);
        return createdProducts.stream().map(CommonUtils::createProductResponseDto).filter(Objects::nonNull).toList();
    }

}
