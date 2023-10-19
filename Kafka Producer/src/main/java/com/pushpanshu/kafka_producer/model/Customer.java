package com.pushpanshu.kafka_producer.model;

import lombok.Data;

@Data
public class Customer {
    private int id;
    private String name;
    private String email;
    private String contactNo;
}
