package com.tutorial.kafka.config;

import com.tutorial.kafka.payload.User;
import com.tutorial.kafka.producer.KafkaProducer;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.*;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public KafkaAdmin admin() {
        Map<String,Object> props = new HashMap<>();
        props.put("bootstrap.servers", "ample-bedbug-14600-us1-kafka.upstash.io:9092");
        props.put("sasl.mechanism", "SCRAM-SHA-512");
        props.put("security.protocol", "SASL_SSL");
        props.put("sasl.jaas.config", "org.apache.kafka.common.security.scram.ScramLoginModule required " +
                "username=\"YW1wbGUtYmVkYnVnLTE0NjAwJBg0L3h30pxxk9AxBGeLOjndiXJvxwbnwbR0p1M\" " +
                "password=\"YTdmOGUwNGEtNGY2Yy00MjVlLThiNzAtMzRmNzNiMWIxOTdh\";");

        return new KafkaAdmin(props);
    }

    @Bean
    public NewTopic topic1(){
        return new NewTopic("development",1,(short)1);
    }

    @Bean
    public ProducerFactory<String,User> kafkaProducerFactory(){
        Map<String, Object> props = new HashMap<>();
        props.put("bootstrap.servers","ample-bedbug-14600-us1-kafka.upstash.io:9092");
        props.put("sasl.mechanism", "SCRAM-SHA-512");
        props.put("security.protocol", "SASL_SSL");
        props.put("sasl.jaas.config", "org.apache.kafka.common.security.scram.ScramLoginModule required " +
                "username=\"YW1wbGUtYmVkYnVnLTE0NjAwJBg0L3h30pxxk9AxBGeLOjndiXJvxwbnwbR0p1M\" " +
                "password=\"YTdmOGUwNGEtNGY2Yy00MjVlLThiNzAtMzRmNzNiMWIxOTdh\";");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.springframework.kafka.support.serializer.JsonSerializer");

        return  new DefaultKafkaProducerFactory<>(props);
    }

    /*@Bean
    public KafkaTemplate<String,String> kafkaTemplate(){
        return new KafkaTemplate<>(kafkaProducerFactory());

    }*/

    @Bean
    public KafkaTemplate<String, User> kafkaTemplate(){
        return new KafkaTemplate<>(kafkaProducerFactory());

    }
}
