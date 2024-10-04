package com.yog.productservice.service;

import com.yog.productservice.models.Category;
import com.yog.productservice.models.Product;
import com.yog.productservice.repository.CategoryRepository;
import com.yog.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceDbImpl implements ProductService{

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public Product getProduct(Long id){
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    public List<Product> createProduct(List<Product> requestedProducts){
        List<Product> products = new ArrayList<>();
        requestedProducts.forEach(

                product -> {
                    Optional<Category> categoryOptional = categoryRepository.findCategoryByCategoryName(product.getCategory().getCategoryName());
                    Category category;
                    if(categoryOptional.isPresent()){
                        product.setCategory(categoryOptional.get());
                    }else{
                        category = new Category();
                        category.setCategoryName(product.getCategory().getCategoryName());
                        product.setCategory(categoryRepository.save(category));
                    }
                    products.add(productRepository.save(product));
                }
        );
        return products;
    }
}
