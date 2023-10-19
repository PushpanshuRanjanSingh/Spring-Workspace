package com.pushpanshu.kafka_producer.controller;

import com.pushpanshu.kafka_producer.model.Customer;
import com.pushpanshu.kafka_producer.service.KafkaProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaEventController {

    private final KafkaProducerService kafkaProducerService;

    public KafkaEventController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

//    @GetMapping("/send/{message}")
//    public ResponseEntity<?> sendMessageToKafkaTopic(@PathVariable String message) {
//        try {
//            for (int i = 0; i < 10000; i++) {
//                kafkaProducerService.sendMessage("[" + i + "]: " + message);
//            }
//            return ResponseEntity.ok("Message sent to Kafka topic successfully!");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }

    @PostMapping("/send")
    public ResponseEntity<?> sendMessageToKafkaTopic(@RequestBody Customer customer) {
        try {
            kafkaProducerService.sendCustomerEvent(customer);
            return ResponseEntity.ok("Message sent to Kafka topic successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
