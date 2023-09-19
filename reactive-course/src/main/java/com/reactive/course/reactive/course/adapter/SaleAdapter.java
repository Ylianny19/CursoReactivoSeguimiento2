package com.reactive.course.reactive.course.adapter;

import com.reactive.course.reactive.course.model.Sale;
import com.reactive.course.reactive.course.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class SaleAdapter {

    public SaleRepository saleRepository;

    public Mono<Sale> getSale (Long id){
        return saleRepository.findById(id);
    }

    public Flux<Sale> getAllSale (){
        return saleRepository.findAll();
    }

}
