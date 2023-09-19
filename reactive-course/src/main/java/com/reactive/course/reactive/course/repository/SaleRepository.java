package com.reactive.course.reactive.course.repository;

import com.reactive.course.reactive.course.model.Sale;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends ReactiveCrudRepository<Sale, Long> {


}
