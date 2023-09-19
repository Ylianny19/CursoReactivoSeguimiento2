package com.reactive.course.reactive.course.adapter;

import com.reactive.course.reactive.course.model.Category;
import com.reactive.course.reactive.course.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class CategoryAdapter {

    public CategoryRepository categoryRepository;


    public Mono<Category> getCategory (Long id){
        return categoryRepository.findById(id);
    }

    public Flux<Category> getAllCategory (){
        return categoryRepository.findAll();
    }
}
