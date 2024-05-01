package com.tutorial.kafka.producer;

import com.tutorial.kafka.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User data){
        kafkaTemplate.send("development",data);
    }
}
