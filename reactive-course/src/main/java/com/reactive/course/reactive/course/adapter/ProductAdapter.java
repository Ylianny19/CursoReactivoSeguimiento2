package com.reactive.course.reactive.course.adapter;

import com.reactive.course.reactive.course.model.Product;
import com.reactive.course.reactive.course.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class ProductAdapter {

    private ProductRepository productRepository;

    @Autowired
    public ProductAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Mono<Product> getProduct (Long id){
        return productRepository.findById(id);
    }

    public Flux<Product> getAllProduct (){
        return productRepository.findAll();
    }

    public Mono<Void> deleteProduct(Long id){
        return productRepository.deleteById(id);
    }

    public Mono<Product> saveProduct(Product product){
        return productRepository.save(product);
    }
}
