package com.reactive.course.reactive.course.service;

import com.reactive.course.reactive.course.adapter.CategoryAdapter;
import com.reactive.course.reactive.course.model.Category;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoryService {

    public CategoryAdapter categoryAdapter;

    public Mono<Category> getCategory(Long id){
        return categoryAdapter.getCategory(id);
    }
    public Flux<Category> getAllCategory(){
        return categoryAdapter.getAllCategory();
    }
}
