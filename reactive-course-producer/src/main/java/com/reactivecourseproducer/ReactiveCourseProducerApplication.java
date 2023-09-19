package com.reactivecourseproducer;

import com.reactivecourseproducer.models.Product;
import com.reactivecourseproducer.services.KafkaProducerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveCourseProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveCourseProducerApplication.class, args);
	}

	private final KafkaProducerService kafkaProducerService;

	public ReactiveCourseProducerApplication(KafkaProducerService kafkaProducerService) {
		this.kafkaProducerService = kafkaProducerService;
	}

	@Override
	public void run(String... args) throws Exception{
		producerData();
	}
	private void producerData(){

		Product product1 = new Product(1, "Leche en polvo", "LP-001", "105");
		Product product2 = new Product(2, "Arroz", "AR-001","200");
		String topico = "Productos-2023-7";
		kafkaProducerService.sendKey(topico, product1.getId(), product1);
		kafkaProducerService.sendKey(topico, product2.getId(), product2);
	}
}
