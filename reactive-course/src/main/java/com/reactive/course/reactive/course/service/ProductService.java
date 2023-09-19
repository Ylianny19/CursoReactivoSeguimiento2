package com.reactive.course.reactive.course.service;


import com.reactive.course.reactive.course.adapter.ProductAdapter;
import com.reactive.course.reactive.course.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService  {

    private ProductAdapter productAdapter;

    @Autowired
    public ProductService(ProductAdapter productAdapter) {
        this.productAdapter = productAdapter;
    }

    public Mono<Product> getProduct(Long id){
        return productAdapter.getProduct(id);
    }
    public Flux<Product> getAllProduct(){
        return productAdapter.getAllProduct();
    }

    public Mono<Void> deleteProduct(Long id) {
        return productAdapter.deleteProduct(id);
    }

    public Mono<Product> saveProduct(Product product) {
        return productAdapter.saveProduct(product);
    }


}
