package com.reactive.course.reactive.course.repository;

import com.reactive.course.reactive.course.model.Category;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends ReactiveCrudRepository<Category, Long> {
}
