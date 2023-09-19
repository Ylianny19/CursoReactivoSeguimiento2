package com.reactive.course.reactive.course.controller;



import com.reactive.course.reactive.course.model.Product;
import com.reactive.course.reactive.course.service.ProductService;
import com.reactive.course.reactive.course.service.kafka.ProductKafkaConsumerService;
import com.reactive.course.reactive.course.service.sqs.ProductSQSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    ProductKafkaConsumerService productKafkaConsumerService;

    @Autowired
    ProductSQSService productSQSService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Mono<Product> getProduct(Long id){
        return productService.getProduct(id);
    }

    @GetMapping()
    public Flux<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteId(Long id){
        return productService.deleteProduct(id);
    }

    @PostMapping()
    public Mono<Product> saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/topico-kakfa/{topico}")
    public Mono<String> getCreditoFromTopicoKafka(@PathVariable String topico) {
        return Mono.just(productKafkaConsumerService.obtenerUltimoProducto(topico));
    }

    @PostMapping("/aws/createQueue")
    public Mono<String> postCreateQueue(@RequestBody Map<String, Object> requestBody){
        return Mono.just(productSQSService.createStandardQueue((String) requestBody.get("queueName")));
    }

    @PostMapping("/aws/postMessageQueue/{queueName}")
    public Mono<String> postMessageQueue(@RequestBody Product product, @PathVariable String queueName){
        return Mono.just(productSQSService.publishStandardQueueMessage(
                queueName,
                2,
                product));
    }
}
