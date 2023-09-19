package com.reactive.course.reactive.course;

import com.reactive.course.reactive.course.adapter.ProductAdapter;
import com.reactive.course.reactive.course.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
/*
    private final ProductRepository productRepository;

    public AppConfig(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Bean
    public ProductAdapter productAdapter() {
        return new ProductAdapter(productRepository);
    }*/
}