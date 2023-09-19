package com.reactive.course.reactive.course.service.sqs;


import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.*;
import com.reactive.course.reactive.course.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductSQSService {

    private final AmazonSQS clienteSQS;

    public ProductSQSService(AmazonSQS clienteSQS) {
        this.clienteSQS = clienteSQS;
    }

    public String createStandardQueue(String queueName){

        CreateQueueRequest createQueueRequest = new CreateQueueRequest(queueName);
        return clienteSQS.createQueue(createQueueRequest).getQueueUrl();
    }

    private String getQueueUrl(String queueName){
        return clienteSQS.getQueueUrl(queueName).getQueueUrl();
    }

    public String publishStandardQueueMessage(String queueName, Integer delaySeconds, Product product){
        Map<String, MessageAttributeValue> atributosMensaje = new HashMap<>();

        atributosMensaje.put("id",
                new MessageAttributeValue()
                        .withStringValue(Optional.ofNullable(product.getId()).orElse(-301L).toString())
                        .withDataType("Number"));
        atributosMensaje.put("nombre",
                new MessageAttributeValue()
                        .withStringValue(product.getNombre())
                        .withDataType("String"));
        atributosMensaje.put("codigo",
                new MessageAttributeValue()
                        .withStringValue(product.getCodigo())
                        .withDataType("String"));
        atributosMensaje.put("stock",
                new MessageAttributeValue()
                        .withStringValue(product.getStock())
                        .withDataType("String"));

        SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(this.getQueueUrl(queueName))
                .withMessageBody(product.getNombre())
                .withDelaySeconds(delaySeconds)
                .withMessageAttributes(atributosMensaje);

        return clienteSQS.sendMessage(sendMessageRequest).getMessageId();
    }


    public void publishStandardQueueMessage(String queueName, Integer delaySeconds, List<Product> products){
        for (Product product : products){
            publishStandardQueueMessage(queueName, delaySeconds, product);
        }
    }

    private List<Message> receiveMessagesFromQueue(String queueName, Integer maxNumberMessages, Integer waitTimeSeconds){
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(this.getQueueUrl(queueName))
                .withMaxNumberOfMessages(maxNumberMessages)
                .withMessageAttributeNames(List.of("All"))
                .withWaitTimeSeconds(waitTimeSeconds);
        return clienteSQS.receiveMessage(receiveMessageRequest).getMessages();
    }

    public Mono<Product> deleteProductMessageInQueue(String queueName, Integer maxNumberMessages,
                                                     Integer waitTimeSeconds, String descripcionCredito){
        List<Message> creditoMessages = receiveMessagesFromQueue(queueName, maxNumberMessages, waitTimeSeconds);
        for(Message message : creditoMessages){
            if(!message.getMessageAttributes().isEmpty()) {
                if (message.getMessageAttributes().get("nombre").getStringValue().equals(descripcionCredito)) {
                    Product product = new Product(Long.valueOf(message.getMessageAttributes().get("id").getStringValue()),
                            message.getMessageAttributes().get("nombre").getStringValue(),
                            message.getMessageAttributes().get("codigo").getStringValue(),
                            message.getMessageAttributes().get("stock").getStringValue());
                    clienteSQS.deleteMessage(this.getQueueUrl(queueName), message.getReceiptHandle());
                    return Mono.just(product);
                }
            }
        }
        return Mono.empty();
    }
}
