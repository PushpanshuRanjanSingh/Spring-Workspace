package com.pushpanshu.kafka_consumer.service;

import com.pushpanshu.kafka_consumer.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    //    Multiple Partition assigned to single Consumer with the help of groupID
    @KafkaListener(topics = "topic-from-config", groupId = "kafka-groupId")
    public void consume(Customer customer) {
        logger.info("Listener: " + customer.toString());
    }

/*
        Multiple Partition assigned to Individual Consumer with the help of groupID
        Here We have 3 partition 4 consumers' group, So Each partition will be assigned to individual based on broker coordinator So,
        in that condition any one of them will be idle. It will be assigned if any consumer goes down.

*/

    @KafkaListener(topics = "topic-from-config-2", groupId = "kafka-groupId-2")
    public void consume1(String message) {
        logger.info("Listener: " + message);
    }

    @KafkaListener(topics = "topic-from-config-2", groupId = "kafka-groupId-2")
    public void consume2(String message) {
        logger.info("Listener: " + message);
    }

    @KafkaListener(topics = "topic-from-config-2", groupId = "kafka-groupId-2")
    public void consume3(String message) {
        logger.info("Listener: " + message);
    }

    @KafkaListener(topics = "topic-from-config-2", groupId = "kafka-groupId-2")
    public void consume4(String message) {
        logger.info("Listener: " + message);
    }
}