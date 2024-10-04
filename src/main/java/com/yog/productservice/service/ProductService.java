package com.yog.productservice.service;

import com.yog.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product getProduct(Long id);

    List<Product> createProduct(List<Product> product);

}
