package com.pushpanshu.kafka_producer.controller;

import com.pushpanshu.kafka_producer.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaEventController {

    @Autowired
    private KafkaService kafkaService;

    @GetMapping("/send/{message}")
    public ResponseEntity<?> sendMessageToKafkaTopic(@PathVariable String message) {
        kafkaService.sendMessage(message);
        return ResponseEntity.ok("Message sent to Kafka topic successfully!");
    }
}
