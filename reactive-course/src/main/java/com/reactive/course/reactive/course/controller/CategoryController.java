package com.reactive.course.reactive.course.controller;

import com.reactive.course.reactive.course.model.Category;
import com.reactive.course.reactive.course.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    public CategoryService categoryService;

    @GetMapping("/{id}")
    public Mono<Category> getCategory (@PathVariable Long id){
        return categoryService.getCategory(id);
    }

    @GetMapping()
    public Flux<Category> getAllCategory (){
        return categoryService.getAllCategory();
    }
}
