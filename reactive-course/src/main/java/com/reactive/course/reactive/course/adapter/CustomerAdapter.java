package com.reactive.course.reactive.course.adapter;

import com.reactive.course.reactive.course.model.Customer;
import com.reactive.course.reactive.course.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class CustomerAdapter {

    public CustomerRepository customerRepository;

    public Mono<Customer> getCustomer (Long id){
        return customerRepository.findById(id);
    }

    public Flux<Customer> getAllCustomer (){
        return customerRepository.findAll();
    }

    public Mono<Void> deleteCustomer(Long id){
        return customerRepository.deleteById(id);
    }

    public Mono<Customer> saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
