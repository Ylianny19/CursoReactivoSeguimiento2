package com.reactivecourseproducer.services;


import com.reactivecourseproducer.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendKey(String topico, Integer key, Product product ){
        var future = kafkaTemplate.send(topico, key.toString(), product.toString());

        future.whenComplete((resultadoEnvio, excepcion) -> {
            if(excepcion != null){
                LOGGER.error(excepcion.getMessage());
                future.completeExceptionally(excepcion);
            } else {
                future.complete(resultadoEnvio);
            }
            LOGGER.info("Producto enviado al topico de Kafka con id"+product);
        });
    }

    public void send(String topico, Product product){
        var future = kafkaTemplate.send(topico, product.toString());

        future.whenComplete((resultadoEnvio, excepcion) -> {
            if(excepcion != null){
                LOGGER.error(excepcion.getMessage());
                future.completeExceptionally(excepcion);
            } else {
                future.complete(resultadoEnvio);
            }
            LOGGER.info("Producto enviado al topico de Kafka "+product);
        });

    }
}

