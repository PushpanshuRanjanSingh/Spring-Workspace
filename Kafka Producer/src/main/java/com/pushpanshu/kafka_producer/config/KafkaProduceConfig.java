package com.pushpanshu.kafka_producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Kafka configuration class where we define Kafka topics, producers configuration
 * that how many partitions and replication factor should be there for each topic
 *
 */
@Configuration
public class KafkaProduceConfig {

    @Value("${this.project.topic}")
    private String topicName;

//    @Value("${this.project.topic2}")
//    private String topicName2;
    @Bean
    public NewTopic createTopic(){
        return new NewTopic(topicName, 1, (short) 1);
    }

//    @Bean
//    public NewTopic createTopic2(){
//        return new NewTopic(topicName2, 3, (short) 1);
//    }

}
