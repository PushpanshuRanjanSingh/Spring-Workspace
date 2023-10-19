package com.pushpanshu.kafka_producer.service;

import com.pushpanshu.kafka_producer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducerService {

    @Value("${this.project.topic}")
    private String topic;

//    @Value("${this.project.topic2}")
//    private String topic2;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;


//    public void sendMessage(String message) {
//        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic2, message);
//        future.whenComplete((result, e) -> {
//            if (e == null) {
//                System.out.println("Message sent successfully to topic " + topic2);
//            } else {
//                System.out.println("Error sending message to topic " + e.getMessage());
//            }
//        });
//    }

    public void sendCustomerEvent(Customer customer) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, customer);
        future.whenComplete((result, e) -> {
            if (e == null) {
                System.out.println("Message sent successfully to topic " + topic);
                System.out.println("Message: " + customer);
            } else {
                System.out.println("Error sending message to topic " + e.getMessage());
            }
        });
    }

}
