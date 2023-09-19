package com.reactive.course.reactive.course.controller;


import com.reactive.course.reactive.course.model.Customer;
import com.reactive.course.reactive.course.service.CustomerService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    public CustomerService customerService;

    @GetMapping("/{id}")
    public Mono<Customer> getCustomer (@PathVariable Long id){
        return customerService.getCustomer(id);
    }

    @GetMapping()
    public Flux<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @PostMapping()
    public Mono<Customer> saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCustomer (@PathVariable Long id){
        return customerService.deleteId(id);
    }


}
