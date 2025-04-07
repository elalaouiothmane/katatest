package com.example.katatest.kafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
    @Bean
    KafkaTemplate<String,String> kafkaTemplate(){
        Map<String,Object> config = new HashMap<>();
        config.put("bootstrap.servers","localhost:9092");
        //TODO Configuration du serilizer
        ProducerFactory producerFactory = null;
        return new KafkaTemplate<>(producerFactory);
    }
}
