package com.reactive.course.reactive.course.service;

import com.reactive.course.reactive.course.adapter.CustomerAdapter;
import com.reactive.course.reactive.course.model.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    public CustomerAdapter customerAdapter;

    public Mono<Customer> getCustomer(Long id){
        return customerAdapter.getCustomer(id);
    }
    public Flux<Customer> getAllCustomer(){
        return customerAdapter.getAllCustomer();
    }

    public Mono<Void> deleteId(Long id){
        return customerAdapter.deleteCustomer(id);
    }
    public Mono<Customer> saveCustomer(Customer customer){
        return customerAdapter.saveCustomer(customer);
    }
}
