package com.reactive.course.reactive.course.controller;

import com.reactive.course.reactive.course.model.Sale;
import com.reactive.course.reactive.course.service.SaleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/sale")
public class SaleController {

    public SaleService saleService;

    @GetMapping("/{id}")
    public Mono<Sale> getSale (@PathVariable Long id){
        return saleService.getSale(id);
    }

    @GetMapping()
    public Flux<Sale> getAllSale(){
        return saleService.getAllSale();
    }
}
