package com.tutorial.kafka.consumer;

import com.tutorial.kafka.payload.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

   /* @KafkaListener(topics = {"development"},groupId = "developers")
    public void consume(String message){
        System.out.println("Received message: "+message);
    }*/

    @KafkaListener(topics = {"development"},groupId = "developers")
    public void consume(User message){
        System.out.println("Received message: "+message.toString());
    }
}
