package com.reactive.course.reactive.course.service;


import com.reactive.course.reactive.course.adapter.SaleAdapter;
import com.reactive.course.reactive.course.model.Category;
import com.reactive.course.reactive.course.model.Sale;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SaleService {

    public SaleAdapter saleAdapter;

    public Mono<Sale> getSale(Long id){
        return saleAdapter.getSale(id);
    }
    public Flux<Sale> getAllSale(){
        return saleAdapter.getAllSale();
    }


}

