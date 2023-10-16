package com.pushpanshu.kafka_producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaService {

    @Value("${this.project.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;


    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, message);
        future.whenComplete((result, e) -> {
            if (e == null) {
                System.out.println("Message sent successfully to topic " + topic);
            } else {
                System.out.println("Error sending message to topic " + e.getMessage());
            }
        });
    }

}
